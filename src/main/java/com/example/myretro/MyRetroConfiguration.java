package com.example.myretro;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    MyRetroConfiguration(ApplicationArguments arguments) {
        log.info("Option Args: {}", arguments.getOptionNames());
        log.info("Option Arg Values: {}", arguments.getOptionValues("option"));
        log.info("Non Option: {}", arguments.getNonOptionArgs());
    }

    @Bean //2
    CommandLineRunner commandLineRunner() {
        return args -> {

            log.info("[CLR] Args: {}", Arrays.toString(args));
        };
    }

    @Bean //1
    ApplicationRunner applicationRunner() {
        return args -> {
            log.info("[AR] Option Args: {}", args.getOptionNames());
            log.info("[AR] Option Arg values: {}", args.getOptionValues("option"));
            log.info("[AR] Non option: {}", args.getNonOptionArgs());
        };
    }

    @Bean //3
    ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener() {
        return event -> {
            log.info("[AL] Im ready to interact...");
        };
    }

}
