package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPrizeTest {
    @DisplayName("LottoPrize 테스트")
    @Test
    public void testFindRank() {
        // Test FIRST prize
        LottoPrize firstPrize = LottoPrize.findRank(6, false);
        assertEquals(LottoPrize.FIRST, firstPrize);

        // Test SECOND prize
        LottoPrize secondPrize = LottoPrize.findRank(5, true);
        assertEquals(LottoPrize.SECOND, secondPrize);

        // Test THIRD prize
        LottoPrize thirdPrize = LottoPrize.findRank(5, false);
        assertEquals(LottoPrize.THIRD, thirdPrize);

        // Test FOURTH prize
        LottoPrize fourthPrize = LottoPrize.findRank(4, false);
        assertEquals(LottoPrize.FOURTH, fourthPrize);

        // Test FIFTH prize
        LottoPrize fifthPrize = LottoPrize.findRank(3, false);
        assertEquals(LottoPrize.FIFTH, fifthPrize);

        // Test NONE prize
        LottoPrize nonePrize = LottoPrize.findRank(0, false);
        assertEquals(LottoPrize.NONE, nonePrize);
    }
}
