package com.angla.demo.datasource;

import com.angla.demo.enums.DataSourceTypeEnum;

/**
 * Title:DataSourceContextHolder
 *
 * @author angla
 **/
public class DataSourceContextHolder {

    private static final ThreadLocal<DataSourceTypeEnum> contextHolder = new ThreadLocal<>();

    static {
        setDatabaseType(DataSourceTypeEnum.DATA_SOURCE_MASTER);
    }
    public static void setDatabaseType(DataSourceTypeEnum databaseType) {
        contextHolder.set(databaseType);
    }

    public static DataSourceTypeEnum getDatabaseType() {
        return contextHolder.get();
    }

}
