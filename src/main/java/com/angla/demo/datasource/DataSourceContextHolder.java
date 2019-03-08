package com.angla.demo.datasource;

import com.angla.demo.enums.DataSourceTypeEnum;

/**
 * Title:DataSourceContextHolder
 *
 * @author liumenghua
 **/
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDatabaseType(DataSourceTypeEnum databaseType) {
        contextHolder.set(databaseType.getName());
    }

    public static String getDatabaseType() {
        return contextHolder.get();
    }

}
