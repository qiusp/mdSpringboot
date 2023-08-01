package com.example.mdspringboot.common.config.swagger2;

import com.example.mdspringboot.common.util.SwaggerUtil;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

// 启用swagger
@EnableKnife4j
@EnableSwagger2
@Configuration
@Slf4j
public class SwaggerConfig {
    // 用户接口组
    // Docket表示接口文档，用于封装接口文档相关信息（如记录扫描哪些包、文档名字、文档信息等）
    @Bean
    public Docket mybatisPlusDocket() {
        return docket("mybatisPlus", "com.example.mdspringboot.modules.mybatisplus");
    }
    @Bean
    public Docket swagger2Docket() {
        return docket("swagger2", "com.example.mdspringboot.modules.swagger2");
    }
    private Docket docket(String groupName, String packagesPath) {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                //创建该Api的基本信息(这些基本信息会展现在文档页面中)
                .apiInfo(apiInfo())
                // groupName : 接口文档组名字
                .groupName(groupName)
                // 是否开启
                .enable(true)
                //函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger ui来展现
                .select()
                //basePackage 表示扫描那个包: 指定需要扫描的包路路径
                .apis(RequestHandlerSelectors.basePackage(packagesPath))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                // 做完登录授权后，通过tocken增加Security授权认证
                .securityContexts(securityContexts())
                .securitySchemes(securitySchemas());
        // .extensions(openApiExtensionResolver.buildExtensions(groupName));
        // .ignoredParameterTypes(BladeUser.class)
        return docket;

    }

    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("^.*$")).build());
    }

    private List<SecurityScheme> securitySchemas() {
        return Lists.newArrayList(SwaggerUtil.clientInfo(), SwaggerUtil.bladeAuth(), SwaggerUtil.bladeTenant());
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverywhere");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference(SwaggerUtil.clientInfo().getName(), authorizationScopes),
                new SecurityReference(SwaggerUtil.bladeAuth().getName(), authorizationScopes),
                new SecurityReference(SwaggerUtil.bladeTenant().getName(), authorizationScopes));
    }

    //构建 api文档的详细信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("API接口文档")
                //创建人
                .contact(new Contact("springBoot-swagger2", "http://localhost:8081/doc.html", "1013135308@qq.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }

}
