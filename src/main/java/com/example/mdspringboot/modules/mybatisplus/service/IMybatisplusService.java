package com.example.mdspringboot.modules.mybatisplus.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mdspringboot.modules.baseModule.pojo.request.Query;
import com.example.mdspringboot.modules.mybatisplus.pojo.entity.Test;
import com.example.mdspringboot.modules.mybatisplus.pojo.model.TestModel;
import com.example.mdspringboot.modules.mybatisplus.pojo.vo.TestVO;

import java.util.List;

/**
 * @Author: Administrator
 * @Description:
 * @Date: 2023/7/7 13:50
 */
public interface IMybatisplusService extends IService<Test>{
    List<Test> getList();
    boolean save(TestModel model);
    boolean delete(Long id);

    IPage<TestVO> getPage(Query query);
}
