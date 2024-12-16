package com.example.demo.config;

import com.example.demo.controller.CountryController;
import com.example.demo.controller.CountryController;
import com.example.demo.security.apiKeyAuthFilter;
import org.glassfish.jersey.server.ResourceConfig;
//import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfig extends ResourceConfig {
    public ServerConfig() {
        register(apiKeyAuthFilter.class);
        register(CountryController.class);
        //register(ProductController.class);
    }
}
