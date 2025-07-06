package com.example.myretro.client;

import java.text.MessageFormat;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.myretro.config.MyRetroProperties;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UsersClient {
    private final String USERS_UR = "/users";

    private final RestTemplate restTemplate = new RestTemplate();

    private MyRetroProperties myRetroProperties;

    public User findUserByEmail(String email) {
        String uri = MessageFormat.format("{0}:{1}{2}/{3}", 
            myRetroProperties.getUsers().getServer(),
            myRetroProperties.getUsers().getPort().toString(),
            USERS_UR, email);
        
        return restTemplate.getForObject(uri, User.class);
    }
}
