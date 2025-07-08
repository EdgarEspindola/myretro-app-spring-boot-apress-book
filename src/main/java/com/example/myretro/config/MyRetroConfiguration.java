package com.example.myretro.config;

import java.util.ArrayList;
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
            RetroBoard retroBoard = retroBoardService.save(RetroBoard.builder()
                //.id(UUID.fromString("9DC9B71B-A07E-418B-B972-40225449AFF2"))
                .name("Spring Boot Conference")
                .build());

            retroBoardService.addMultipleCardsToRetroBoard(retroBoard.getId(),new ArrayList<>() {{
                add(Card.builder().comment("Spring Boot Rocks!").cardType(CardType.HAPPY).build());
                add(Card.builder().comment("Meet everyone in person").cardType(CardType.HAPPY).build());
                add(Card.builder().comment("When is the next one?").cardType(CardType.MEH).build());
                add(Card.builder().comment("Not enough time to talk to everyone").cardType(CardType.SAD).build());
            }});
        };
    }
}
