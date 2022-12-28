package com.attson.knife4jserver.config;

import com.attson.knife4jserver.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableConfigurationProperties(ServerConfig.class)
public class ApplicationConfiguration implements WebMvcConfigurer {
    @Autowired
    ServerConfig serverConfig;

    @Autowired
    LoginUserService loginUserService;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .exposedHeaders("X-Auth-Id", "x-auth-id")
                .allowedHeaders("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        UserLoginInterceptor userLoginInterceptor = new UserLoginInterceptor(loginUserService);
        registry.addInterceptor(userLoginInterceptor).excludePathPatterns("/v3/api-docs/swagger-config");
    }
}
