package com.example.mdspringboot.modules.mybatisplus.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Administrator
 * @Description:
 * @Date: 2023/7/25 16:33
 */
@Data
@AllArgsConstructor
@TableName("test")
public class Test {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "user_name")
    private String userName;

    private String passWord;

    private Integer isDeleted;

    // insert的时候触发的时候自动填充
    @TableField(fill = FieldFill.INSERT)
    private String createTime;

    // update的时候触发的时候自动填充
    @TableField(fill = FieldFill.INSERT)
    private String updateTime;


}
