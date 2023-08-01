package com.example.mdspringboot.modules.swagger2.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mdspringboot.modules.baseModule.pojo.request.Query;
import com.example.mdspringboot.modules.mybatisplus.pojo.entity.Test;
import com.example.mdspringboot.modules.mybatisplus.pojo.model.TestModel;
import com.example.mdspringboot.modules.mybatisplus.pojo.vo.TestVO;
import com.example.mdspringboot.modules.mybatisplus.service.IMybatisplusService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author: Administrator
 * @Description: 格式
 * @Date: 2023/7/7 13:47
 */
@RestController
@RequestMapping("/swagger2")
@Api(tags = "swagger2接口测试", value = "swagger2")
public class Swagger2Controller {

    @Autowired
    private IMybatisplusService service;

    @PostMapping("/save")
    @ApiOperation(value = "保存", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperationSupport(order = 1)
    public Object save(@RequestBody TestModel model){
        return service.save(model);
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除")
    @ApiOperationSupport(order = 2)
    public Object delete(@ApiParam(value = "id", required =  true) @RequestParam(value = "id") Long id){
        return service.delete(id);
    }

    @PostMapping("/getList")
    @ApiOperation(value = "获取列表")
    @ApiOperationSupport(order = 3)
    public List<Test> getList(){
        return service.getList();
    }

    @PostMapping("/getPage")
    @ApiOperation(value = "分页", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperationSupport(order = 4)
    public IPage<TestVO> getPage(@RequestBody Query query){
        return service.getPage(query);
    }

}
