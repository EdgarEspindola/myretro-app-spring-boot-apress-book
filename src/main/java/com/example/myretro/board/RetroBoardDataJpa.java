package com.example.myretro.board;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class RetroBoardDataJpa {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @NotBlank(message = "A name must be provided")
    private String name;
    
    @Singular
    @OneToMany(mappedBy = "retroBoard")
    private List<CardDataJpa> cards = new ArrayList<>();
}
