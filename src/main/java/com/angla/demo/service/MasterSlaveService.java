package com.angla.demo.service;

import com.angla.demo.model.MasterSlaveModel;
import org.springframework.stereotype.Service;

/**
 *  Service
 * @author liumenghua
 * @project hshcics
 * @date  2019-1-24 14:47:55
 */
@Service("masterSlaveService")
public interface MasterSlaveService {


    Object insert(MasterSlaveModel masterSlave);

    Object getList(MasterSlaveModel masterSlave);
}