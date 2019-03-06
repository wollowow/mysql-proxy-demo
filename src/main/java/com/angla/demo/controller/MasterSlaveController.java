package com.angla.demo.controller;

import com.angla.demo.model.MasterSlaveModel;
import com.angla.demo.service.MasterSlaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器
 *
 * @author liumenghua
 * @project hshcics
 * @date 2019-1-24 14:47:55
 */
@Controller
@RequestMapping("masterSlave")
public class MasterSlaveController {

    @Autowired
    private MasterSlaveService masterSlaveService;


    /**
     * 保存
     **/
    @RequestMapping("insert")
    @ResponseBody
    public Object insert(HttpServletRequest req, MasterSlaveModel masterSlave) {
        return masterSlaveService.insert(masterSlave);
    }

    /**
     * 保存
     **/
    @RequestMapping("getList")
    @ResponseBody
    public Object getList(HttpServletRequest req, MasterSlaveModel masterSlave) {
        return masterSlaveService.getList(masterSlave);
    }
}