package com.example.myretro.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myretro.board.RetroBoardDataJpa;

public interface RetroBoardRepositoryDataJpa extends JpaRepository<RetroBoardDataJpa, UUID> {

}
