package co.com.manuel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT =
            new Contact("Manuel Alejandro Lopez Gutierrez","www.linkedin.com/in/alejolopez5","alejoloopez5@gmail.com");
    public static final ApiInfo DEFAULT_API_INFO =
            new ApiInfo("Xmen", "Aplicacion para prueba", "1.0",
                    "Costumize",DEFAULT_CONTACT,"","", new ArrayList<>());
    private static final Set<String> DEFAULT_PRODUCES_CONSUMES_AND_CONSUMES =
            new HashSet<>(Collections.singletonList("application/json"));


    @Bean
    public Docket docketApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_CONSUMES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_CONSUMES_AND_CONSUMES)
                .useDefaultResponseMessages(false)
                .select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }
}
