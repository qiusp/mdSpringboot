# springboot整合[mybatis-plus](https://www.baomidou.com/pages/24112f/)
## 1、环境
### 1.1 导入依赖
    导入依赖后即可使用
    <!--mybatis-plus-->
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>3.4.2</version>
    </dependency>

    [IDEA按照一个插件Maven Helper可以查看是否有依赖冲突。]()

配置说明：

    配置文件（全局配置）：
        xml文件配置【mapper-locations】
        sql日志打印配置
        字段配置【id、自动驼峰、逻辑删除（初始化加入填充器0）】
    注解：
        1、实体基本注解配置(@TableName，@TableField)
        2、（局部配置）字段配置：
            【@TableId id】、
            【逻辑删除（@TableLogic(value = "0", delval = "1")初始化加入填充器0】、自动填充（注解+填充器）】
            【@TableField 字段配置（1、策略是否为空）】
        3、mapper接口扫描（@MapperScan【全局】和@Mapper【局部】）
        
### 1.2、[配置文件](https://baomidou.com/pages/56bac0/#%E5%9F%BA%E6%9C%AC%E9%85%8D%E7%BD%AE)

1.2.1、mybatis-plus:
    
    A、xml文件(mapper-locations):
        mapper-locations: classpath:*/mapper/*.xml  #指定sql映射文件

        [A.1、Mybatis-Plus中Mapper的接口文件与xml文件存放位置问题](https://blog.csdn.net/weixin_42925623/article/details/126251037)
        
        [A.2、maven的＜resources＞标签里＜include＞**/*.xml＜/include＞配置是什么意思](https://blog.csdn.net/Adeluoo/article/details/124610637)
             
            <!--将src/main/java目录下的所有xml文件都作为项目的资源文件，编译打包时会进行预编译并打包进去，“**” 表示任意级目录,“*.xml” 表示任意xml文件-->
            <resources>
                <resource>
                    <directory>src/main/java</directory>
                    <includes>
                        <include>**/*.xml</include>
                    </includes>
                    <!--filtering标签默认是false,表示include标签中的文件不需要预编译并打入包中；true表示需要被预编译打包-->
                    <filtering>true</filtering>
                </resource>
            </resources>
    
    B、实体(type-aliases-package)：

        [B.1 Mybatis Plus基础07 type-aliases-package配置(实体对象扫描包)](https://blog.csdn.net/h470789634/article/details/124581547)

1.2.2、configuration    

    A.sql日志：
        log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

1.2.3、global-config:

    A.db-config
        [A、字段](https://www.baomidou.com/pages/6b03c5/#%E6%AD%A5%E9%AA%A4-1-%E9%85%8D%E7%BD%AEcom-baomidou-mybatisplus-core-config-globalconfig-dbconfig)
                
        A.1、逻辑删除
            #全局配置逻辑删除字段名
            logic-delete-field: isDeleted
            #逻辑已删除值（默认1）
            logic-delete-value: 1
            #逻辑未删除值（默认0）
            logic-not-delete-value: 0
    
        A.2、id规则：
            id-type: assign_id
    
        A.3、null策略
            #字段验证策略之 insert,在 insert 的时候的字段验证策略:不为空（可在注解@TableField局部修改）
            insert-strategy: not_null
            #字段验证策略之 update,在 update 的时候的字段验证策略
            update-strategy: not_null
    B.banner: true #是否控制台 print mybatis-plus 的 LOGO

    
### 1.3、[常用注解](https://www.baomidou.com/pages/223848/#tablename)
    1、@TableLogic逻辑删除
        @TableLogic可以自定义逻辑删除的值，可以不受全局配置影响

    2、@TableField
        2.1、自动填充
            实体注解(@TableField(fill = FieldFill.INSERT_UPDATE))->封装自动填充器
            @TableField(fill = FieldFill.INSERT_UPDATE)
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            private Date updateTime;
    
            package com.example.mdspringboot.common.config.mybatisPlus;
            import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
            import lombok.extern.slf4j.Slf4j;
            import org.apache.ibatis.reflection.MetaObject;
            import org.springframework.stereotype.Component;
    
            import java.util.Date;
              @Slf4j
              @Component
              public class MyMetaObjectHandler implements MetaObjectHandler {
              @Override
              public void insertFill(MetaObject metaObject) {
                  log.info("start insert fill ....");
                  this.strictInsertFill(metaObject, "createTime", Date.class, new Date()); // 起始版本 3.3.0(推荐使用)
                  this.strictInsertFill(metaObject, "isDeleted", Integer.class, 0); // 起始版本 3.3.0(推荐使用)
                  this.strictInsertFill(metaObject, "updateTime", Date.class, new Date()); // 起始版本 3.3.0(推荐)
            }
            
                @Override
                public void updateFill(MetaObject metaObject) {
                    log.info("start update fill ....");
                    this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date()); // 起始版本 3.3.0(推荐)
                }
            }
    
        2.2、null策略(全局配置不为空)
            //忽略全局配置
            @TableField(value = "pass_word", updateStrategy = FieldStrategy.IGNORED)
            也可直接用updateWrapper,将字段修改成null

    [3、@MapperScan和@Mapper](https://blog.csdn.net/china_coding/article/details/126925825)
        @Mapper作用：在接口类上添加了@Mapper，在编译之后会生成相应的接口实现类
        @MapperScan作用：指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
        @MapperScan路劲：mapper包下接口文件所在的完整路劲

### 1.4、[封装公共实体类](https://blog.csdn.net/Herishwater/article/details/127983149)

## 2、使用
### 2.1、[基本文件结构](https://blog.csdn.net/weixin_45737330/article/details/127059233)
    entity: 继承公共实体 BaseEntity
        package com.example.mdspringboot.modules.mybatisplus.pojo.entity;
        import com.baomidou.mybatisplus.annotation.TableField;
        import com.baomidou.mybatisplus.annotation.TableName;
        import com.example.mdspringboot.modules.baseModule.pojo.entity.BaseEntity;
        import lombok.Data;
        import java.io.Serializable;

        @Data
        @TableName("test")
        public class Test extends BaseEntity implements Serializable {
            private static final long serialVersionUID = 1L;
        
            @TableField(value = "user_name")
            private String userName;
        
            @TableField(value = "pass_word")
            private String passWord;
        }

    mapper:
        package com.example.mdspringboot.modules.mybatisplus.mapper;
        import com.baomidou.mybatisplus.core.mapper.BaseMapper;
        import com.example.mdspringboot.modules.mybatisplus.pojo.entity.Test;
        import org.apache.ibatis.annotations.Mapper;
        import org.springframework.stereotype.Repository;
        @Repository
        @Mapper
        public interface TestMapper extends BaseMapper<Test> {
        }

    xml(使用mybatisX根据Mapper生成):
        <?xml version="1.0" encoding="UTF-8" ?>
        <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
        <mapper namespace="com.example.mdspringboot.modules.mybatisplus.mapper.TestMapper">
        </mapper>


    service（接口）:
        package com.example.mdspringboot.modules.mybatisplus.service;
        import com.baomidou.mybatisplus.extension.service.IService;
        import com.example.mdspringboot.modules.mybatisplus.pojo.entity.Test;
        import com.example.mdspringboot.modules.mybatisplus.pojo.model.TestModel;
        import java.util.List;
        public interface IMybatisplusService extends IService<Test>{
            List<Test> getList();

            boolean save(TestModel model);
        }

    serviceImpl（接口实现）:
        package com.example.mdspringboot.modules.mybatisplus.service.impl;
        import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
        import com.example.mdspringboot.modules.mybatisplus.mapper.TestMapper;
        import com.example.mdspringboot.modules.mybatisplus.pojo.entity.Test;
        import com.example.mdspringboot.modules.mybatisplus.pojo.model.TestModel;
        import com.example.mdspringboot.modules.mybatisplus.service.IMybatisplusService;
        import org.springframework.beans.BeanUtils;
        import org.springframework.stereotype.Service;
        import java.util.List;
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
        }

    controller: （待完成）BaseController
### 2.2、[分页](https://baomidou.com/pages/2976a3/)
    插件bean
        package com.example.mdspringboot.common.config.mybatisPlus;
        import com.baomidou.mybatisplus.annotation.DbType;
        import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
        import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        @Configuration
        public class MybatisPlusPageConfig {
        
          @Bean
          public MybatisPlusInterceptor mybatisPlusInterceptor() {
          MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
          interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
          return interceptor;
          }
        }
        注：由于以及在启动器上加上@MapperScan({"com.example.mdspringboot.modules.*.mapper"})，所以这边不再加


    controller
        @PostMapping("/getPage")
        public IPage<TestVO> getPage(@RequestBody Query query){
            return service.getPage(query);
        }
    
    service接口
        IPage<TestVO> getPage(Query query);

    serviceImpl
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

    mapper
        List<Test> getPage(IPage<TestVO> page, @Param("query") Query query);
    xml
        <select id="getPage" resultType="com.example.mdspringboot.modules.mybatisplus.pojo.entity.Test">
            select * from test
        </select>
    

### 2.3、代码自动生成（待完成）
### 2.4、条件构造器（wapper使用）
### 2.5、mapper（xml）

## 3、和lommok做比较（待完成）

## 4、问题
4.1、expected single matching bean but found 2: mybatisplusServiceImpl,IMybatisplusService

[发现问题出现在@MapperScan：需要指定mapper路劲](https://blog.csdn.net/weixin_43118901/article/details/109153215)

4.2、Error creating bean with name 'mybatisplusServiceImpl': Unsatisfied dependency expressed through field 'baseMapper';

    问题：找不到Mapper接口bean
    解决：修改@MapperScan() 路劲为{"com.example.mdspringboot.modules.*.mapper"}
