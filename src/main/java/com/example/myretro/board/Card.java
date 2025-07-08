package com.example.myretro.board;

import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Card {
    @Id
    private UUID id;

    @NotBlank
    private String comment;
    
    @NotNull
    private CardType cardType;
    
}
