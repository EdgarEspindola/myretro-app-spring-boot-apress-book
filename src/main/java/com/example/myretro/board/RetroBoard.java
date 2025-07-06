package com.example.myretro.board;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RetroBoard {
    private UUID id;

    @NotBlank(message = "A name must be provided")
    private String name;
    
    @Singular
    private Map<UUID,Card> cards = new HashMap<>();
}
