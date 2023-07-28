package com.example.mdspringboot.modules.baseModule.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: Administrator
 * @Description: 公共实体类
 * @Date: 2023/7/26 10:14
 */
@Data
public class BaseEntity {
    @TableId(
            value = "id",
            type = IdType.ASSIGN_ID
    )
    private Long id;

    // insert的时候触发的时候自动填充
    @TableField(value = "create_time",fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // update的时候触发的时候自动填充
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @TableLogic(value = "0", delval = "1")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer isDeleted;
}
