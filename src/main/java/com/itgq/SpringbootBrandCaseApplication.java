package com.itgq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;


// 访问路径 ： http://localhost:8080/brand.html
@SpringBootApplication
public class SpringbootBrandCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBrandCaseApplication.class, args);
    }

}
