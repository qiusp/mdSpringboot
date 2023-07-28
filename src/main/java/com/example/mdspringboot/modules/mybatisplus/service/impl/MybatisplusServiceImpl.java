package com.example.mdspringboot.modules.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mdspringboot.modules.baseModule.pojo.request.Query;
import com.example.mdspringboot.modules.mybatisplus.mapper.TestMapper;
import com.example.mdspringboot.modules.mybatisplus.pojo.entity.Test;
import com.example.mdspringboot.modules.mybatisplus.pojo.model.TestModel;
import com.example.mdspringboot.modules.mybatisplus.pojo.vo.TestVO;
import com.example.mdspringboot.modules.mybatisplus.service.IMybatisplusService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Administrator
 * @Description:
 * @Date: 2023/7/7 13:50
 */
@Service
public class MybatisplusServiceImpl extends ServiceImpl<TestMapper, Test> implements IMybatisplusService {

    @Override
    public List<Test> getList() {
        List<Test> tests = this.list();
        return tests;
    }

    @Override
    public boolean save(TestModel model) {
        Test test = new Test();
        BeanUtils.copyProperties(model, test);
        return this.save(test);
    }

    @Override
    public boolean delete(Long id) {
        LambdaQueryWrapper<Test> wrapper = Wrappers.<Test>lambdaQuery().eq(Test::getId,id);
        this.getOne(wrapper);
        return this.removeById(id);
    }

    @Override
    public IPage<TestVO> getPage(Query query) {
        IPage<TestVO> page = new Page<>(query.getCurrent(), query.getSize());
        List<Test> tests = baseMapper.getPage(page, query);
        List<TestVO> testVOS = new ArrayList<>();
        for (Test test : tests) {
            TestVO testVO = new TestVO();
            BeanUtils.copyProperties(test, testVO);
            testVOS.add(testVO);
        }
        page.setRecords(testVOS);
        return page;
    }
}
