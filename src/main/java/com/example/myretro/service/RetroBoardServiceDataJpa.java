package com.example.myretro.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myretro.board.CardDataJpa;
import com.example.myretro.board.RetroBoardDataJpa;
import com.example.myretro.exception.CardNotFoundException;
import com.example.myretro.exception.RetroBoardNotFoundException;
import com.example.myretro.persistence.CardRepositoryDataJpa;
import com.example.myretro.persistence.RetroBoardRepositoryDataJpa;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RetroBoardServiceDataJpa {
    RetroBoardRepositoryDataJpa retroBoardRepository;
    CardRepositoryDataJpa cardRepository;

    public RetroBoardDataJpa save(RetroBoardDataJpa domain) {
        return this.retroBoardRepository.save(domain);
    }

    @Transactional
    public RetroBoardDataJpa findById(UUID uuid) {
        RetroBoardDataJpa retroBoard = this.retroBoardRepository.findById(uuid).get();
        retroBoard.getCards().size(); // Force load cards

        return retroBoard;
    }

    public Iterable<RetroBoardDataJpa> findAll() {
        return this.retroBoardRepository.findAll();
    }

    public void delete(UUID uuid) {
        this.retroBoardRepository.deleteById(uuid);
    }

    @Transactional
    public Iterable<CardDataJpa> findAllCardsFromRetroBoard(UUID uuid) {
        return this.findById(uuid).getCards();
    }

    public CardDataJpa addCardToRetroBoard(UUID uuid, CardDataJpa card){
        CardDataJpa result = retroBoardRepository.findById(uuid).map(retroBoard -> {
            card.setRetroBoard(retroBoard);
            return cardRepository.save(card);
        }).orElseThrow(() -> new RetroBoardNotFoundException());

        return result;
    }

    @Transactional
    public void addMultipleCardsToRetroBoard(UUID uuid, List<CardDataJpa> cards) {
        RetroBoardDataJpa retroBoard = this.findById(uuid);
        cards.forEach(card -> card.setRetroBoard(retroBoard));
        cardRepository.saveAll(cards);
    }

    public CardDataJpa findCardByUUID(UUID uuidCard){
        Optional<CardDataJpa> result = cardRepository.findById(uuidCard);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new CardNotFoundException();
        }
    }

    public CardDataJpa saveCard(CardDataJpa card){
        return cardRepository.save(card);
    }
    
    public void removeCardByUUID(UUID cardUUID){
        cardRepository.deleteById(cardUUID);
    }
}
