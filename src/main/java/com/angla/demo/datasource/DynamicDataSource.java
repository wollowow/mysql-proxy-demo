package com.angla.demo.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Title:DynamicDataSource
 *
 * @author liumenghua
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDatabaseType();
    }
}
