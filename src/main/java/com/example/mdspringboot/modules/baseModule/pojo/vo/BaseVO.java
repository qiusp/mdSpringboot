package com.example.mdspringboot.modules.baseModule.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Administrator
 * @Description:
 * @Date: 2023/7/25 16:33
 */
@Data
public class BaseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String userName;

    private String passWord;



}
