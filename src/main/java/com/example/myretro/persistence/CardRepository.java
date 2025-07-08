package com.example.myretro.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myretro.board.Card;

public interface CardRepository extends JpaRepository<Card, UUID> {

}
