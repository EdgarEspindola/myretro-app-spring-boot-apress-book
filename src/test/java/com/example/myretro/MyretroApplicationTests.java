package com.example.myretro;

import java.util.Collection;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.myretro.board.Card;
import com.example.myretro.board.CardType;
import com.example.myretro.board.RetroBoard;
import com.example.myretro.exception.CardNotFoundException;
import com.example.myretro.exception.RetroBoardNotFoundException;
import com.example.myretro.service.RetroBoardService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class MyretroApplicationTests {

    @Autowired
    RetroBoardService service;

    UUID retroBoardUUID = UUID.fromString("9DC9B71B-A07E-418B-B972-40225449AFF2");
    UUID cardUUID = UUID.fromString("BB2A80A5-A0F5-4180-A6DC-80C84BC014C9");
    UUID mehCardUUID = UUID.fromString("775A3905-D6BE-49AB-A3C4-EBE287B51539");
    
    @Test
    void saveRetroBoardTest() {
        RetroBoard retroBoard = service.save(RetroBoard.builder().name("Gathering 2023").build());
        assertThat(retroBoard).isNotNull();
        assertThat(retroBoard.getId()).isNotNull();
    }

    @Test
    void findAllRetroBoardsTest() {
        Iterable<RetroBoard> retroBoards = service.findAll();
        assertThat(retroBoards).isNotNull();
        assertThat(retroBoards).isNotEmpty();
    }

    @Test
    void cardsRetroBoardNotFoundTest() {
        assertThatThrownBy(() -> {
            service.findAllCardsFromRetroBoard(UUID.randomUUID());
        }).isInstanceOf(RetroBoardNotFoundException.class);
    }

    @Test
    void  findRetroBoardTest(){
        RetroBoard retroBoard = service.findById(retroBoardUUID);
        assertThat(retroBoard).isNotNull();
        assertThat(retroBoard.getName()).isEqualTo("Spring Boot Conference");
        assertThat(retroBoard.getId()).isEqualTo(retroBoardUUID);
    }
   
    @Test
    void findCardsInRetroBoardTest(){
        RetroBoard retroBoard = service.findById(retroBoardUUID);
        assertThat(retroBoard).isNotNull();
        assertThat(retroBoard.getCards()).isNotEmpty();
    }

    @Test
    void addCardToRetroBoardTest() {
        Card card = service.addCardToRetroBoard(retroBoardUUID, Card.builder().comment("Amazing session").cardType(CardType.HAPPY).build());
        assertThat(card).isNotNull();
        assertThat(card.getId()).isNotNull();

        RetroBoard retroBoard = service.findById(retroBoardUUID);
        assertThat(retroBoard).isNotNull();
        assertThat(retroBoard.getCards()).isNotEmpty();
    }

    @Test
    void findAllCardsFromRetroBoardTest() {
        Iterable<Card> cardList = service.findAllCardsFromRetroBoard(retroBoardUUID);
        assertThat(cardList).isNotNull();
        assertThat(((Collection) cardList).size()).isGreaterThan(3);
    }
    
    @Test
    void removeCardsFromRetroBoardTest(){
        service.removeCardByUUID(retroBoardUUID, cardUUID);
        RetroBoard retroBoard = service.findById(retroBoardUUID);
        assertThat(retroBoard).isNotNull();
        assertThat(retroBoard.getCards()).isNotEmpty();
        assertThat(retroBoard.getCards()).hasSizeLessThan(4);
    }
    
    @Test
    void findCardByIdInRetroBoardTesT(){
        Card card = service.findCardByUUID(retroBoardUUID, mehCardUUID);
        assertThat(card).isNotNull();
        assertThat(card.getId()).isEqualTo(mehCardUUID);
    }

    @Test
    void notFoundCardInRetroBoardTest() {
        assertThatThrownBy(() -> {
            service.findCardByUUID(retroBoardUUID, UUID.randomUUID());
        }).isInstanceOf(CardNotFoundException.class);
    }
}
