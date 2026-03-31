package com.bookmycar.bookmycar.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.*;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("oauth2", new SecurityScheme()
                                .type(SecurityScheme.Type.OAUTH2)
                                .flows(new OAuthFlows()
                                        .authorizationCode(new OAuthFlow()
                                                .authorizationUrl("https://github.com/login/oauth/authorize")
                                                .tokenUrl("https://github.com/login/oauth/access_token")
                                                .scopes(new Scopes()
                                                        .addString("read:user", "Read user info")
                                                        .addString("user:email", "Read user email")
                                                )
                                        )
                                )
                        )
                );
    }
}