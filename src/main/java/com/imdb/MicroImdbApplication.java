package com.imdb;

import com.imdb.service.impl.NameBasicService;
import com.imdb.util.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@EnableAsync
@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = {"com.imdb.service.impl",
        "com.imdb.mapper", "com.imdb.*"})
public class MicroImdbApplication extends WebMvcConfigurerAdapter
{

    @Autowired
    private NameBasicService nameBasicService;

    public static void main(String[] args)
    {
        SpringApplication.run(MicroImdbApplication.class, args);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/**");
    }


    @Bean
    public Docket docket()
    {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName()))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(generateApiInfo());
    }


    private ApiInfo generateApiInfo()
    {
        return new ApiInfo("Micro Imdb Applicant Service", "This service is to provide beneficial API for reaching imdb data.", "Version 1.0 - mw",
            "urn:tos", "colakogluilker@gmail.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
    }

    @PostConstruct
    public void fillTitleMap(){
        nameBasicService.fillTitleMap();
        System.out.println("TitleMap has been filled");
    }
}
