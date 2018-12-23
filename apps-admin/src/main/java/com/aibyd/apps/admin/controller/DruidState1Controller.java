package com.aibyd.apps.admin.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */

@RestController
public class DruidState1Controller {
    @GetMapping("/druid1/state1")
    public Object druidStat() {
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }
}