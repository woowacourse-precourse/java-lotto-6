package lotto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultTest {

    @Test
    public void testGetRank() {
        Result firstPrizeResult = Result.of(6, false);
        Result secondPrizeResult = Result.of(5, true);
        Result thirdPrizeResult = Result.of(5, false);
        Result fourthPrizeResult = Result.of(4, false);
        Result fifthPrizeResult = Result.of(3, false);
        Result noPrizeResult = Result.of(2, false);

        assertEquals(Rank.FIRST, firstPrizeResult.getRank());
        assertEquals(Rank.SECOND, secondPrizeResult.getRank());
        assertEquals(Rank.THIRD, thirdPrizeResult.getRank());
        assertEquals(Rank.FOURTH, fourthPrizeResult.getRank());
        assertEquals(Rank.FIFTH, fifthPrizeResult.getRank());
        assertEquals(Rank.NONE, noPrizeResult.getRank());
    }

    @Test
    public void testGetPrize() {
        Result firstPrizeResult = Result.of(6, false);
        Result secondPrizeResult = Result.of(5, true);
        Result thirdPrizeResult = Result.of(5, false);
        Result fourthPrizeResult = Result.of(4, false);
        Result fifthPrizeResult = Result.of(3, false);
        Result noPrizeResult = Result.of(2, false);

        assertEquals(Rank.FIRST.getReward(), firstPrizeResult.getPrize());
        assertEquals(Rank.SECOND.getReward(), secondPrizeResult.getPrize());
        assertEquals(Rank.THIRD.getReward(), thirdPrizeResult.getPrize());
        assertEquals(Rank.FOURTH.getReward(), fourthPrizeResult.getPrize());
        assertEquals(Rank.FIFTH.getReward(), fifthPrizeResult.getPrize());
        assertEquals(0, noPrizeResult.getPrize());
    }
}
