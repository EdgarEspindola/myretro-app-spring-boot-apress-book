package com.example.myretro.board;

import java.util.List;
import java.util.UUID;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Builder
@Data
public class RetroBoard {

    private UUID id;
    
    @NotNull
    @NotBlank(message = "A name must be provided")
    private String name;
    
    @Singular
    private List<Card> cards;
}
