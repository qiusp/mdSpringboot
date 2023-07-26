package com.example.mdspringboot.modules.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mdspringboot.modules.baseModule.pojo.request.Query;
import com.example.mdspringboot.modules.mybatisplus.pojo.entity.Test;
import com.example.mdspringboot.modules.mybatisplus.pojo.vo.TestVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Administrator
 * @Description:
 * @Date: 2023/7/25 16:45
 */
public interface TestMapper extends BaseMapper<Test> {

    List<Test> getPage(IPage<TestVO> page, @Param("query") Query query);
}
