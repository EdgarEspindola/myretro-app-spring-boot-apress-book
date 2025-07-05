package com.example.myretro;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRetroConfiguration {
    Logger log = LoggerFactory.getLogger(MyRetroConfiguration.class);

    @Value("${users.server}")
    String server;
    @Value("${users.port}")
    Integer port;
    @Value("${users.username}")
    String username;
    @Value("${users.password}")
    String password;

    @Bean
    ApplicationListener<ApplicationReadyEvent> init() {
        return event -> {
            log.info("\nThe users service properties are:\n- Server: {}\n- Port: {}\n- Username: {}\n- Password: {}",
                    server, port, username, password);
        };
    }
}
