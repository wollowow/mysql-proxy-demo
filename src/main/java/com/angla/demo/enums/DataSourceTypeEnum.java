package com.angla.demo.enums;

/**
 * Title:DataSourceTypeEnum
 *
 * @author angla
 **/

public enum  DataSourceTypeEnum {

    DATA_SOURCE_MASTER(1,"master"),
    DATA_SOURCE_SLAVE(2,"slave");

    DataSourceTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private Integer code;

    private String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
