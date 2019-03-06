package com.angla.demo.commom;

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
        return sqlSessionTemplate.update(id,param);
    }

    public int delete(String id, Object param) {
        return 0;
    }

    public int insert(String id, Object param) {
        return sqlSessionTemplate.insert(id,param);
    }

    public <T> List<T> queryList(String id, Object param) {
        return sqlSessionTemplate.selectList(id,param);
    }

    public <T> List<T> queryList(String id) {
        return sqlSessionTemplate.selectList(id);
    }

    public <T> T queryOne(String id, Object param) {
        return sqlSessionTemplate.selectOne(id,param);
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
