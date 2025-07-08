package com.example.myretro.persistence;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.example.myretro.board.RetroBoard;


public interface RetroBoardRepository extends CrudRepository<RetroBoard, UUID> {
}
