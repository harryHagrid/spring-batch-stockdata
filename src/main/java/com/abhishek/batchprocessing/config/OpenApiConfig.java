package com.abhishek.batchprocessing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
//	@Value("${app.swagger.title}")
//	private String title;
//	
//	@Value("${app.swagger.summary}")
//	private String summary;
//	
//	@Value("${app.swagger.version}")
//	private String version;
	
	@Autowired
	private SwaggerProperties props;
 
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                		.title(this.props.getTitle())
                		.version(this.props.getVersion())
                		.description(this.props.getSummary())
                        );
    }

    
}