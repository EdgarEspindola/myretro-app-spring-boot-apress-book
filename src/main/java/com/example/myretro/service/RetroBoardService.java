package com.example.myretro.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myretro.board.Card;
import com.example.myretro.board.RetroBoard;
import com.example.myretro.exception.CardNotFoundException;
import com.example.myretro.exception.RetroBoardNotFoundException;
import com.example.myretro.persistence.CardRepository;
import com.example.myretro.persistence.RetroBoardRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RetroBoardService {
    RetroBoardRepository retroBoardRepository;
    CardRepository cardRepository;

    public RetroBoard save(RetroBoard domain) {
        return this.retroBoardRepository.save(domain);
    }

    @Transactional
    public RetroBoard findById(UUID uuid) {
        RetroBoard retroBoard = this.retroBoardRepository.findById(uuid).get();
        retroBoard.getCards().size(); // Force load cards

        return retroBoard;
    }

    public Iterable<RetroBoard> findAll() {
        return this.retroBoardRepository.findAll();
    }

    public void delete(UUID uuid) {
        this.retroBoardRepository.deleteById(uuid);
    }

    @Transactional
    public Iterable<Card> findAllCardsFromRetroBoard(UUID uuid) {
        return this.findById(uuid).getCards();
    }

    public Card addCardToRetroBoard(UUID uuid, Card card){
        Card result = retroBoardRepository.findById(uuid).map(retroBoard -> {
            card.setRetroBoard(retroBoard);
            return cardRepository.save(card);
        }).orElseThrow(() -> new RetroBoardNotFoundException());

        return result;
    }

    @Transactional
    public void addMultipleCardsToRetroBoard(UUID uuid, List<Card> cards) {
        RetroBoard retroBoard = this.findById(uuid);
        cards.forEach(card -> card.setRetroBoard(retroBoard));
        cardRepository.saveAll(cards);
    }

    public Card findCardByUUID(UUID uuidCard){
        Optional<Card> result = cardRepository.findById(uuidCard);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new CardNotFoundException();
        }
    }

    public Card saveCard(Card card){
        return cardRepository.save(card);
    }
    
    public void removeCardByUUID(UUID cardUUID){
        cardRepository.deleteById(cardUUID);
    }
}
