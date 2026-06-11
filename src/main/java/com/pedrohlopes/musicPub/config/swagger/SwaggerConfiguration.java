package com.pedrohlopes.musicPub.config.swagger;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Music Pub")
                .description("Documentação das rotas do sistema de relacionamento entre " +
                        "artistas e estabelecimentos MusicPub.")
        );
    }

    @SecurityScheme(
            name = "bearerAuth",
            type = SecuritySchemeType.HTTP,
            scheme = "bearer",
            bearerFormat = "JWT"
    )

    public class OpenApiConfig {
    }
}
