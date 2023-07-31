package com.example.mdspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan({"com.example.mdspringboot.modules.*.mapper"})
@ComponentScan("com.example.mdspringboot.common.config.swagger2")
public class MdSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MdSpringbootApplication.class, args);
    }

}
