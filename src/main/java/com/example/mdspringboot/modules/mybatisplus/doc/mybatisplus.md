# springboot整合mybatis-plus
## 1、环境
### 1.1 导入依赖
    <!--mybatis-plus-->
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>3.4.2</version>
    </dependency>

    [IDEA按照一个插件Maven Helper可以查看是否有依赖冲突。]()

### 1.2、配置文件
    xml文件扫描、sql日志、[待完善]字段（id、逻辑删除、驼峰）
    

配置说明：
1、mapper-locations:
1.1、[Mybatis-Plus中Mapper的接口文件与xml文件存放位置问题](https://blog.csdn.net/weixin_42925623/article/details/126251037)
1.2、[maven的＜resources＞标签里＜include＞**/*.xml＜/include＞配置是什么意思](https://blog.csdn.net/Adeluoo/article/details/124610637)

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

2、type-aliases-package
[2.1 Mybatis Plus基础07 type-aliases-package配置(实体对象扫描包)](https://blog.csdn.net/h470789634/article/details/124581547)
### 1.3、常用注解
和lommok做比较

## 2、使用
### 2.1、[基本文件结构](https://blog.csdn.net/weixin_45737330/article/details/127059233)
    entity:(待完善) 继承基本实体
    xml:
    mapper:
    service:
    serviceImpl:
    controller: （待完成）继承基本控制器
### 2.2、分页
### 2.3、代码自动生成

## 3、问题
    expected single matching bean but found 2: mybatisplusServiceImpl,IMybatisplusService
