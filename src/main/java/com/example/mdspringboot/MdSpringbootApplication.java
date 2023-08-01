package com.example.mdspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.example.mdspringboot.modules.*.mapper"})
public class MdSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MdSpringbootApplication.class, args);
    }

}
