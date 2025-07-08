package com.example.myretro.board;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Card {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @NotBlank
    private String comment;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private CardType cardType;
    
    @ManyToOne
    @JoinColumn(name = "retro_board_id")
    @JsonIgnore
    RetroBoard retroBoard;
}
