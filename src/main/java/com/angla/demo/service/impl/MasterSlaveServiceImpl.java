package com.angla.demo.service.impl;

import com.angla.demo.dao.MasterSlaveDao;
import com.angla.demo.model.MasterSlaveModel;
import com.angla.demo.service.MasterSlaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service
 *
 * @author liumenghua
 * @project hshcics
 * @date 2019-1-24 14:47:55
 */
@Service("masterSlaveService")
public class MasterSlaveServiceImpl implements MasterSlaveService {

    @Autowired
    private MasterSlaveDao masterSlaveDao;


    @Override
    public Object insert(MasterSlaveModel masterSlave) {
        return masterSlaveDao.insert(masterSlave);
    }

    public Object getList(MasterSlaveModel masterSlave) {
        return masterSlaveDao.getList(masterSlave);
    }

}