package com.angla.demo.dao;

import com.angla.demo.model.MasterSlaveModel;

/**
* 
* @author liumenghua
* @project hshcics
* @date  2019-1-24 14:47:55
*/

public interface MasterSlaveDao  {

    int insert(MasterSlaveModel masterSlave);

    Object queryList(MasterSlaveModel masterSlave);
}