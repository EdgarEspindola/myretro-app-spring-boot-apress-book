package com.example.myretro.persistence;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.example.myretro.board.RetroBoardDataJdbc;

public interface RetroBoardRepositoryDataJdbc extends CrudRepository<RetroBoardDataJdbc, UUID> {

}
