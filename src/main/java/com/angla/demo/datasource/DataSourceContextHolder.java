package com.angla.demo.datasource;

/**
 * Title:DataSourceContextHolder
 *
 * @author liumenghua
 **/
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDatabaseType(String dbKey) {
        contextHolder.set(dbKey);
    }

    public static String getDatabaseType() {
        return contextHolder.get();
    }

}
