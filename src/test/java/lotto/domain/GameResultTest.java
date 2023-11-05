package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void 로또_랭크를_입력하면_해당_랭크를_카운트한다() {
        GameResult gameResult = GameResult.create();
        gameResult.add(Rank.THIRD);
        gameResult.add(Rank.SECOND);
        gameResult.add(Rank.SECOND);
        gameResult.add(Rank.FIFTH);
        gameResult.add(Rank.FIFTH);

        Assertions.assertEquals(2, gameResult.getCountOfRank(Rank.SECOND));
        Assertions.assertEquals(1, gameResult.getCountOfRank(Rank.THIRD));
        Assertions.assertEquals(2, gameResult.getCountOfRank(Rank.FIFTH));
    }

    @Test
    void 카운트한_로또_랭크의_수익을_계산한다() {
        GameResult gameResult = GameResult.create();
        gameResult.add(Rank.FIFTH);
        gameResult.add(Rank.FIFTH);
        gameResult.add(Rank.SECOND);

        long expectedValue = (Rank.FIFTH.getPrizeMoney() * 2L) + Rank.SECOND.getPrizeMoney();
        long actualValue = gameResult.calculateProfit();

        Assertions.assertEquals(expectedValue, actualValue);
    }
}
