package com.sample.reactive.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class WebFluxConfig implements WebFluxConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Register the H2 Console as a static resource
        registry.addResourceHandler("/h2-console/**")
                .addResourceLocations("classpath:/static/h2-console/");
    }
}

