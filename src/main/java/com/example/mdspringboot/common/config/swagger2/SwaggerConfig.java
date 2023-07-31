package com.example.mdspringboot.common.config.swagger2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// 启用swagger
//@EnableSwagger2
@Configuration
@Slf4j
public class SwaggerConfig {
    // 用户接口组
    // Docket表示接口文档，用于封装接口文档相关信息（如记录扫描哪些包、文档名字、文档信息等）
    @Bean
    public Docket createRestApi1() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                // groupName : 接口文档组名字
                .apiInfo(apiInfo()).groupName("用户接口组")//创建该Api的基本信息(这些基本信息会展现在文档页面中)
                .select() //函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger ui来展现
                // basePackage 表示扫描那个包
                .apis(RequestHandlerSelectors.basePackage("com.example.mdspringboot.modules.mybatisplus.controller")) //指定需要扫描的包路路径
                .paths(PathSelectors.any()) //
                .build();
        return docket;
    }

    //构建 api文档的详细信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("API接口文档")
                //创建人
                .contact(new Contact("springBoot-swagger2", "https://blog.csdn.net/qq_40036754", ""))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }

}
