package com.example.mdspringboot.modules.mybatisplus.pojo.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mdspringboot.modules.baseModule.pojo.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Administrator
 * @Description:
 * @Date: 2023/7/25 16:33
 */
@Data
@TableName("test")
public class Test extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "pass_word", updateStrategy = FieldStrategy.IGNORED)
    private String passWord;

}
