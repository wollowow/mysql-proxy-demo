package com.angla.demo.commom;

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;

/**
 * Title:CommonBaseDao
 *
 * @author liumenghua
 **/
public class CommonBaseDao extends CommonDaoImpl {

    @Resource(name = "sqlSessionTemplate")
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate template) {

        super.setSqlSessionTemplate(template);
    }
}
