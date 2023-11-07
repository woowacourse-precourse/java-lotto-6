package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrizeTest {

    @Test
    void testCheckWinningPrize() {
        // Test for SIX_BALL_MATCHES
        Prize sixBallPrize = Prize.checkWinningPrize(6, false);
        assertEquals(Prize.SIX_BALL_MATCHES, sixBallPrize);

        // Test for FIVE_BALL_WITH_BONUS_MATCHES
        Prize fiveBallWithBonusPrize = Prize.checkWinningPrize(5, true);
        assertEquals(Prize.FIVE_BALL_WITH_BONUS_MATCHES, fiveBallWithBonusPrize);

        // Test for FIVE_BALL_MATCHES
        Prize fiveBallPrize = Prize.checkWinningPrize(5, false);
        assertEquals(Prize.FIVE_BALL_MATCHES, fiveBallPrize);

        // Test for FOUR_BALL_MATCHES
        Prize fourBallPrize = Prize.checkWinningPrize(4, false);
        assertEquals(Prize.FOUR_BALL_MATCHES, fourBallPrize);

        // Test for THREE_BALL_MATCHES
        Prize threeBallPrize = Prize.checkWinningPrize(3, false);
        assertEquals(Prize.THREE_BALL_MATCHES, threeBallPrize);

        // Test for NO_WINNING_PRIZE
        Prize noWinningPrize = Prize.checkWinningPrize(0, false);
        assertEquals(Prize.NO_WINNING_PRIZE, noWinningPrize);

    }
}
