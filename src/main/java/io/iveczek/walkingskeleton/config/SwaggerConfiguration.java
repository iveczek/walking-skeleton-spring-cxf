package io.iveczek.walkingskeleton.config;

import lombok.Data;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Data
public class SwaggerConfiguration {

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.version}")
    private String version;

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.basePath}")
    private String basePath;

    @Value("${swagger.prettyPrint}")
    private boolean prettyPrint;

    @ConfigurationProperties(prefix = "swagger")
    @Bean
    public Swagger2Feature swagger2Feature() {
        return new Swagger2Feature();
    }

}
