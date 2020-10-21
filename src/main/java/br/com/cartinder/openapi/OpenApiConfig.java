package br.com.cartinder.openapi;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(
		info = @Info(title = "CarTinder  API", version = "v1"), 
		security = @SecurityRequirement(name = "jwtOauth2Security" )
		)
@SecurityScheme(
		name = "jwtOauth2Security",
		type = SecuritySchemeType.OAUTH2,
		in = SecuritySchemeIn.HEADER,
		scheme = "bearer",
		bearerFormat = "JWT",

		flows = @OAuthFlows(
				password = @OAuthFlow(
						tokenUrl = "/api/oauth/token",
						scopes = {
								@OAuthScope(name = "read", description = "read access"),
								@OAuthScope(name = "write", description = "write access")
						}
						)

				)
		)
public class OpenApiConfig {



}