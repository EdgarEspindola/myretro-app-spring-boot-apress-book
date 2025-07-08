package com.example.myretro.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myretro.board.CardDataJpa;

public interface CardRepositoryDataJpa extends JpaRepository<CardDataJpa, UUID> {

}
