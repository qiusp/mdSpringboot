package com.example.mdspringboot.modules.mybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mdspringboot.modules.baseModule.pojo.request.Query;
import com.example.mdspringboot.modules.mybatisplus.pojo.entity.Test;
import com.example.mdspringboot.modules.mybatisplus.pojo.model.TestModel;
import com.example.mdspringboot.modules.mybatisplus.pojo.vo.TestVO;
import com.example.mdspringboot.modules.mybatisplus.service.IMybatisplusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author: Administrator
 * @Description: 格式
 * @Date: 2023/7/7 13:47
 */
@RestController
@RequestMapping("/mybatisplus")
@Api(tags = "mybatisPlus")
public class MybatisplusController {

    @Autowired
    private IMybatisplusService service;

    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public Object save(@RequestBody TestModel model){
        return service.save(model);
    }

    @GetMapping("/delete")
    public Object delete(@RequestParam(value = "id") Long id){
        return service.delete(id);
    }

    @PostMapping("/getList")
    public List<Test> test(){
        return service.getList();
    }

    @PostMapping("/getPage")
    public IPage<TestVO> getPage(@RequestBody Query query){
        return service.getPage(query);
    }

}
