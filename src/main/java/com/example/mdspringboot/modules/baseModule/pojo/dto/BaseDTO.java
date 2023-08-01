package com.example.mdspringboot.modules.baseModule.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: qiusp
 * @Description:   
 * @Date: 2023/7/31 11:26
 */

@Data
public class BaseDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    @ApiModelProperty(value = "方案基本信息ID", hidden = true)
    private Long id;

    @ApiModelProperty(value = "基础方案ID")
    private Long facultyId;

    @ApiModelProperty(value = "系级单位")
    private Long orgUnitId;

    @ApiModelProperty(value = "单位名称")
    private String orgUnitName;

    @ApiModelProperty(value = "是否选任：1-选任；2-换届")
    private Integer isSelect;

    @ApiModelProperty(value = "选任主任职数")
    private Integer directorNum;

    @ApiModelProperty(value = "选任副主任职数")
    private Integer deputyDirectorNum;

}
