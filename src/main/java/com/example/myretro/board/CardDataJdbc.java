package com.example.myretro.board;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class CardDataJdbc {
    @Id
    private UUID id;

    @NotBlank
    private String comment;
    
    @NotNull
    private CardType cardType;
    
    @JsonIgnore
    private UUID retroBoardId;
}
