package com.neoflextask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        //http://localhost:8080/calculation/methodName/?first=x&second=y
        //http://localhost:8080/swagger-ui/index.html#/
        SpringApplication.run(Application.class, args);
    }

}
