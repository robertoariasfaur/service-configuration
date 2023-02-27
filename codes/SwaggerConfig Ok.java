package es.humandata.tech.resource.anotacion.config;


import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Anotador-API")
                .apiInfo(usersApiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths())
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo usersApiInfo() {
        return new ApiInfoBuilder()
                .title("H.D-Anotador Service")
                .description("Microservicio para las ejecuciones de las anotaciones")
                .version("1.0")
                .build();
    }

    private Predicate<String> paths() {

        return or(
                regex("/anotador.*"),
                regex("/propagacion.*"),
                regex("/v1/some.*"),
                regex("/v1/contacts.*"),
                regex("/v1/pet.*"),
                regex("/v1/springsRestController.*"),
                regex("/v1/test.*"));
    }

}