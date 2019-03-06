package com.angla.demo.commom;

import com.angla.demo.datasource.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * Title:CommonDaoImpl
 *
 * @author liumenghua
 **/

@Slf4j
public class CommonDaoImpl implements CommonDao{

    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public int update(String id, Object param) {
        DataSourceContextHolder.setDatabaseType("master");
        return sqlSessionTemplate.update(id,param);
    }

    public int delete(String id, Object param) {
        return 0;
    }

    public int insert(String id, Object param) {
        DataSourceContextHolder.setDatabaseType("master");
        int result =  sqlSessionTemplate.insert(id,param);
        return result;
    }

    public <T> List<T> queryList(String id, Object param) {
        DataSourceContextHolder.setDatabaseType("slave");
        return sqlSessionTemplate.selectList(id,param);
    }

    public <T> List<T> queryList(String id) {
        return null;
    }

    public <T> T queryOne(String id, Object param) {
        return null;
    }

    public <T> T queryOne(String id) {
        return null;
    }

    public int queryCount(String id, Object param) {
        return 0;
    }

    public int queryCount(String id) {
        return 0;
    }

    public int batchInsert(String id, List list) {
        return 0;
    }

    public int batchUpdate(String id, List list) {
        return 0;
    }

    public int batchDelete(String id, List list) {
        return 0;
    }
}
