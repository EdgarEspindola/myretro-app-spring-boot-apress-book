package com.example.myretro.board;

import java.util.UUID;

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
public class Card {
    private UUID id;

    @NotBlank
    private String comment;
    
    @NotNull
    private CardType cardType;
    
    private UUID retroBoardId;
}
