package com.example.mdspringboot;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.mdspringboot.modules.mybatisplus.mapper.TestMapper;
import com.example.mdspringboot.modules.mybatisplus.pojo.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class MdSpringbootApplicationTests {

    @Autowired
    DataSource dataSource;

    @org.junit.jupiter.api.Test
    void testSqlConnetion() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    /**
     * 验证连接池的配置信息，是否生效
     * @throws Exception
     */
    @org.junit.jupiter.api.Test
    void testDruidConnetion() throws Exception {
        System.out.println(dataSource.getClass());
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("initSize:" + druidDataSource.getInitialSize());
        System.out.println("maxSize:" + druidDataSource.getMaxActive());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @org.junit.jupiter.api.Test
    void contextLoads() {
    }


    // ---------------------mybatisplus-----------------------
    @Resource
    private TestMapper mapper;

    @org.junit.jupiter.api.Test
    public void testMybatisplus(){
        Test test = mapper.selectById(1);
        System.out.println(test);
    }

}
