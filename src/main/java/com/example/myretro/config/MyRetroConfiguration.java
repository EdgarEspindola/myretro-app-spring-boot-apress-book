package com.example.myretro.config;

import java.util.UUID;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.myretro.board.Card;
import com.example.myretro.board.CardType;
import com.example.myretro.board.RetroBoard;
import com.example.myretro.service.RetroBoardService;

@EnableConfigurationProperties({MyRetroProperties.class})
@Configuration
public class MyRetroConfiguration {
    @Bean
    ApplicationListener<ApplicationReadyEvent> ready(RetroBoardService retroBoardService) {
        return applicationReadyEvent -> {
            UUID retroBoardId = UUID.fromString("9dc9b71b-a07e-418b-b972-40225449aff2");
            RetroBoard retroBoard = RetroBoard.builder()
                    .id(retroBoardId)
                    .name("Spring Boot Conference")
                            .card(UUID.fromString("bb2a80a5-a0f5-4180-a6dc-80c84bc014c9"),Card.builder().id(UUID.fromString("bb2a80a5-a0f5-4180-a6dc-80c84bc014c9")).comment("Spring Boot Rocks!").cardType(CardType.HAPPY).build())
                            .card(UUID.fromString("f9de7f11-5393-4b5b-8e9d-10eca5f50189"),Card.builder().id(UUID.randomUUID()).comment("Meet everyone in person").cardType(CardType.HAPPY).build())
                            .card(UUID.fromString("6cdb30d6-43f2-42b7-b0db-f3acbc53d467"),Card.builder().id(UUID.randomUUID()).comment("When is the next one?").cardType(CardType.MEH).build())
                            .card(UUID.fromString("9de1f7f9-2470-4c8d-86f2-371203620fcd"),Card.builder().id(UUID.randomUUID()).comment("Not enough time to talk to everyone").cardType(CardType.SAD).build())
                    .build();
            retroBoardService.save(retroBoard);
        };
    }
}
