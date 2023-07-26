package com.example.mdspringboot.modules.mybatisplus.service.impl;

import com.example.mdspringboot.modules.mybatisplus.service.IBaseService;
import org.springframework.stereotype.Service;

/**
 * @Author: Administrator
 * @Description:
 * @Date: 2023/7/7 13:50
 */
@Service
public class BaseServiceImpl implements IBaseService {
    @Override
    public String baseInterface() {
        return "测试";
    }
}
