package lotto.dto;

import lotto.model.Game;

import java.util.List;

public record GameDto(
        List<Integer> gameResults,
        double profit
) {
    public GameDto(Game game) {
        this(game.getResultInfo(), game.getGameProfit());
    }
}
