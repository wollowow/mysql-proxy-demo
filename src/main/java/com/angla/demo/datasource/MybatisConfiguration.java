package com.angla.demo.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.angla.demo.enums.DataSourceTypeEnum;
import com.angla.demo.intercept.SqlInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;


/**
 * Title:MybatisConfiguration
 *
 * @author angla
 **/

@Configuration
public class MybatisConfiguration {

    @Autowired
    private Environment env;

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    SqlInterceptor sqlExplainInterceptor() {
        return new SqlInterceptor();
    }

    /**
     * 创建数据源(数据源的名称：方法名可以取为XXXDataSource(),XXX为数据库名称,该名称也就是数据源的名称)
     */
    @Bean
    public List<DataSource> masterDataSources() throws Exception {

        List<Map<String, String>> mastersources = dataSourceProperties.getMastersources();
        if (CollectionUtils.isEmpty(mastersources)) {
            throw new IllegalArgumentException("需要至少一个主数据源");
        }
        List<DataSource> dataSources = new ArrayList<>();
        for (Map map : mastersources) {
            dataSources.add(DruidDataSourceFactory.createDataSource(map));
        }
        return dataSources;
    }

    @Bean
    public List<DataSource> slaveDataSources() throws Exception {
        List<Map<String, String>> slavesources = dataSourceProperties.getSlavesources();
        if (CollectionUtils.isEmpty(slavesources)) {
            throw new IllegalArgumentException("需要至少一个从数据源");
        }
        List<DataSource> dataSources = new ArrayList<>();
        for (Map map : slavesources) {
            dataSources.add(DruidDataSourceFactory.createDataSource(map));
        }
        return dataSources;
    }

    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Bean
    @Primary
    @DependsOn({"masterDataSources", "slaveDataSources"})
    public DynamicDataSource dataSource(List<DataSource> masterDataSources, List<DataSource> slaveDataSources) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        for (int i = 0; i < masterDataSources.size(); i++) {
            targetDataSources.put(DataSourceTypeEnum.DATA_SOURCE_MASTER.getName() + i, masterDataSources.get(i));
        }
        for (int i = 0; i < slaveDataSources.size(); i++) {
            targetDataSources.put(DataSourceTypeEnum.DATA_SOURCE_SLAVE.getName() + i, slaveDataSources.get(i));
        }

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(slaveDataSources.get(0));// 默认的datasource设置为myTestDbDataSource

        return dataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);// 指定数据源
        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));// 指定基包
        fb.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(Objects.requireNonNull(env.getProperty(
                        "mybatis.mapperLocations"))));
        return fb.getObject();
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

}
