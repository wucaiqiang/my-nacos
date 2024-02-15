package com.sk.user.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket docker() {
        List<Parameter> pars = new ArrayList<>();
        pars.add(new ParameterBuilder().name("Authorization").required(false).parameterType("header").modelRef(new ModelRef("string")).description("token信息，需要token的接口必传").build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select()//
                .apis(RequestHandlerSelectors.basePackage("com.sk.user")).paths(PathSelectors.any())//
                .build()
                .globalOperationParameters(pars)
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
//                .apiInfo(apiInfo())//
//                .enable(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("接口文档")//
                .contact(new Contact("api", "api.com", "admin@api.com"))//
                .description("全局错误码描述：errCode=0表示成功，非0的全部表示失败。 401:未授权 999:系统异常。 其他均为业务验证失败，不符合规范。请检查相关参数和业务约定 <br/>")//
                .version("1.0.0")//
                .build();
    }

    private List<ApiKey> securitySchemes() {
        return Arrays.asList(new ApiKey("Authorization", "Authorization", "header"));
    }

    private List<SecurityContext> securityContexts() {
        return Arrays.asList(SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("^(?!auth).*$")).build());
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
    }
}
