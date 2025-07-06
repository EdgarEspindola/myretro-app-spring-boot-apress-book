package com.example.myretro.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix="service")
@Data
public class MyRetroProperties {
    UsersConfiguration users;
}
