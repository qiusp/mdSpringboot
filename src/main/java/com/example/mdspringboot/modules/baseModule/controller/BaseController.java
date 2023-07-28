package com.example.mdspringboot.modules.baseModule.controller;

import com.example.mdspringboot.modules.baseModule.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: Administrator
 * @Description: 格式
 * @Date: 2023/7/7 13:47
 */
@RestController
@RequestMapping("/base")
public class BaseController {
    // @Resource
    // private IBaseService baseService;
    //
    // @Autowired
    // private JdbcTemplate jdbcTemplate;
    //
    // @GetMapping("/baseInterface")
    // public String test(){
    //     return baseService.baseInterface();
    // }
    //
    // @RequestMapping("selectAll")
    // public List<Map<String,Object>> selectAll(){
    //     String sql = "select * from user";
    //     List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
    //     return maps;
    // }
}
