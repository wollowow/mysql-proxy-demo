package com.angla.demo.datasource;

import com.angla.demo.enums.DataSourceTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Title:DynamicDataSource
 *
 * @author angla
 **/
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    protected Object determineCurrentLookupKey() {
        DataSourceTypeEnum dataSourceType = DataSourceContextHolder.getDatabaseType();
        int i;
        List masterSources = dataSourceProperties.getMastersources();
        List slaveSources = dataSourceProperties.getSlavesources();
        if (dataSourceType.equals(DataSourceTypeEnum.DATA_SOURCE_MASTER)) {
            i = ThreadLocalRandom.current().nextInt(masterSources.size()) % masterSources.size();
        } else {
            i = ThreadLocalRandom.current().nextInt(slaveSources.size()) % slaveSources.size();
        }
        return dataSourceType.getName() + i;
    }
}
