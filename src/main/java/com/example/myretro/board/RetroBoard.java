package com.example.myretro.board;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash("RETRO_BOARD")
public class RetroBoard {
    @Id
    @NotNull
    private UUID id;

    @NotBlank(message = "A name must be provided")
    private String name;
    
    @Singular
    private List<Card> cards;
}
