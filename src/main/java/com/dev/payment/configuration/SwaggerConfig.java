package com.dev.payment.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Invoice Payment API")
                        .description("Backend service for handling invoice payments")
                        .version("v1.0.0")
                        .license(new License().name("MIT").url("https://opensource.org/licenses/MIT"))
                )
                .servers(List.of(new Server().url("/http://localhost:5000")));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("v1")
                .packagesToScan( "com.dev.payment.controller")
                .pathsToMatch("/api/**")
                .build();
    }
}
