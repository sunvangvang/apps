package com.aibyd.apps.admin.controller;

import java.util.List;

import javax.annotation.Resource;

import com.aibyd.apps.core.util.ResponseUtil;
import com.aibyd.apps.db.domain.SysUser;
import com.aibyd.apps.db.service.SysUserService;
import com.alibaba.fastjson.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sys/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping(path = "/all")
    public @ResponseBody JSONObject all(@RequestParam String userName) throws Exception {
        // List<SysUser> users = sysUserService.queryByUserName(userName);
        List<SysUser> users = sysUserService.querySelective(userName);
        return ResponseUtil.ok(users);
    }

}