package com.angla.demo.dao.impl;

import com.angla.demo.commom.CommonBaseDao;
import com.angla.demo.dao.MasterSlaveDao;
import com.angla.demo.model.MasterSlaveModel;
import org.springframework.stereotype.Repository;

/**
 * Title:MasterSlaveDaoImpl
 *
 * @author liumenghua
 **/
@Repository
public class MasterSlaveDaoImpl extends CommonBaseDao implements MasterSlaveDao {

    public int insert(MasterSlaveModel masterSlave) {
        return insert("com.angla.demo.dao.MasterSlaveDao.insert", masterSlave);
    }

    public Object queryList(MasterSlaveModel masterSlave) {
        return queryList("com.angla.demo.dao.MasterSlaveDao.getList", masterSlave);
    }
}
