package com.neoflextask;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableWebMvc
@Configuration
public class ApplicationConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.neoflextask"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo getApiInfo(){
        var contact=new Contact("Artem Sheveiko","-","steamon138@gmail.com");
        return new ApiInfoBuilder()
                .title("Calculator")
                .description("Incredibly powerful math system")
                .version("1.0")
                .contact(contact)
                .build();
    }
}
