package com.example.myretro.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;
import com.example.myretro.board.Card;
import com.example.myretro.board.CardType;
import com.example.myretro.board.RetroBoard;

public class RetroBoardRowMapperJdbcTemplate implements RowMapper<RetroBoard> {
    @Override
    public RetroBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
        RetroBoard retroBoard = new RetroBoard();
        retroBoard.setId(UUID.fromString(rs.getString("id")));
        retroBoard.setName(rs.getString("name"));
        
        Map<UUID, Card> cards = new HashMap<>();
        do {
            Card card = new Card();
            card.setId(UUID.fromString(rs.getString("card_id")));
            card.setComment(rs.getString("comment"));
            card.setCardType(CardType.valueOf(rs.getString("card_type")));
            card.setRetroBoardId(retroBoard.getId());
            cards.put(card.getId(), card);
        } while (rs.next() && retroBoard.getId().equals(UUID.fromString(rs.getString("id"))));
        retroBoard.setCards(cards);
        return retroBoard;
    }
}
