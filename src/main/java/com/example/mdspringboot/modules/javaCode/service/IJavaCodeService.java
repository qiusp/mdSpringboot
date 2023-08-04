package com.example.mdspringboot.modules.javaCode.service;


import java.util.Map;

/**
 * @Author: Administrator
 * @Description:
 * @Date: 2023/7/7 13:50
 */
public interface IJavaCodeService{

    String tryJava(String code);
    String tryJavaMap(Map<String, String> map);
}
