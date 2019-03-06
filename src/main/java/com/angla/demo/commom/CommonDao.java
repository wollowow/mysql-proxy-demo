package com.angla.demo.commom;

import java.util.List;

/**
 * Title:CommonDao
 *
 * @author liumenghua
 **/
public interface CommonDao {



    int update(String id, Object param);

    int delete(String id, Object param);

    int insert(String id, Object param);

    <T> List<T> queryList(String id, Object param);

    <T> List<T> queryList(String id);

    <T> T queryOne(String id, Object param);

    <T> T queryOne(String id);

    int queryCount(String id, Object param);

    int queryCount(String id);

    int batchInsert(final String id, final List list);

    int batchUpdate(final String id, final List list);

    int batchDelete(final String id, final List list);
}
