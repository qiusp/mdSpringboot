package com.example.mdspringboot.modules.baseModule.controller;

import com.example.mdspringboot.modules.baseModule.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Administrator
 * @Description: 格式
 * @Date: 2023/7/7 13:47
 */
@RestController
@RequestMapping("/base")
public class BaseController {
    // @Autowired
    @Resource
    private IBaseService baseService;

    @GetMapping("/baseInterface")
    public String test(){
        return baseService.baseInterface();
    }
}
