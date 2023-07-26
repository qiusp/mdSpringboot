package com.example.mdspringboot.modules.baseModule.pojo.request;

import lombok.Data;

/**
 * @Author: Administrator
 * @Description: 分页查询
 * @Date: 2023/7/26 16:54
 */
@Data
public class Query {
    Integer current;
    Integer size;
}
