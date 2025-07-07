package com.example.myretro.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.myretro.board.Card;
import com.example.myretro.board.RetroBoard;
import com.example.myretro.persistence.RetroBoardRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RetroBoardService {
    RetroBoardRepository retroBoardRepository;

    public RetroBoard save(RetroBoard domain) {
        return this.retroBoardRepository.save(domain);
    }

    public RetroBoard findById(UUID uuid) {
        return this.retroBoardRepository.findById(uuid).get();
    }

    public Iterable<RetroBoard> findAll() {
        return this.retroBoardRepository.findAll();
    }

    public void delete(UUID uuid) {
        this.retroBoardRepository.deleteById(uuid);
    }

    public Iterable<Card> findAllCardsFromRetroBoard(UUID uuid) {
        return this.findById(uuid).getCards().values();
    }

    public Card addCardToRetroBoard(UUID uuid, Card card){
        RetroBoard retroBoard = this.findById(uuid);
        if (card.getId() == null) {
            card.setId(UUID.randomUUID());
        }
        retroBoard.getCards().put(card.getId(),card);
        this.save(retroBoard);
        return card;
    }

    public Card findCardByUUID(UUID  uuid,UUID uuidCard){
        RetroBoard retroBoard = this.findById(uuid);
        return retroBoard.getCards().get(uuidCard);
    }

    public Card saveCard(UUID  uuid,Card card){
        RetroBoard retroBoard = this.findById(uuid);
        retroBoard.getCards().put(card.getId(),card);
        this.save(retroBoard);
        return card;
    }
    
    public void removeCardByUUID(UUID uuid,UUID cardUUID){
        RetroBoard retroBoard = this.findById(uuid);
        retroBoard.getCards().remove(cardUUID);
        this.save(retroBoard);
    }
}
