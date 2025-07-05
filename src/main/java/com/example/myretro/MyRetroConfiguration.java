package com.example.myretro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({MyRetroProperties.class})
@Configuration
public class MyRetroConfiguration {
    Logger log = LoggerFactory.getLogger(MyRetroConfiguration.class);

    @Bean
    ApplicationListener<ApplicationReadyEvent> init(MyRetroProperties myRetroProperties) {
        return event -> {
            log.info("\nThe users service properties are:\n- Server: {}\n- Port: {}\n- Username: {}\n- Password: {}",
                    myRetroProperties.getUsers().getServer(),
                    myRetroProperties.getUsers().getPort(),
                    myRetroProperties.getUsers().getUsername(),
                    myRetroProperties.getUsers().getPassword());
        };
    }
}
