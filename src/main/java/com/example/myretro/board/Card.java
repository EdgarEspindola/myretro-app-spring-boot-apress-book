package com.example.myretro.board;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Card {
    private UUID id;

    @NotBlank(message = "A comment must be provided always")
    @NotNull
    private String comment;
    
    @NotNull(message = "A CardType HAPPY|MEH|SAD must be provided")
    private CardType cardType;
}
