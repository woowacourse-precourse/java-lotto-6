package lotto.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LotteryPrizeTest {
    @Test
    public void testGetMatchingResult() {
        assertEquals("6개 일치", LotteryPrize.FIRST.getMatchingResult());
        assertEquals("5개 일치, 보너스 볼 일치", LotteryPrize.SECOND.getMatchingResult());
        assertEquals("5개 일치", LotteryPrize.THIRD.getMatchingResult());
        assertEquals("4개 일치", LotteryPrize.FOURTH.getMatchingResult());
        assertEquals("3개 일치", LotteryPrize.FIFTH.getMatchingResult());
    }

    @Test
    public void testGetPrizeAmount() {
        assertEquals(2000000000, LotteryPrize.FIRST.getPrizeAmount());
        assertEquals(30000000, LotteryPrize.SECOND.getPrizeAmount());
        assertEquals(1500000, LotteryPrize.THIRD.getPrizeAmount());
        assertEquals(50000, LotteryPrize.FOURTH.getPrizeAmount());
        assertEquals(5000, LotteryPrize.FIFTH.getPrizeAmount());
    }

    @Test
    public void testAddCount() {
        LotteryPrize.FIRST.addCount();
        LotteryPrize.FIFTH.addCount();

        assertEquals(1, LotteryPrize.FIRST.getCount());
        assertEquals(0, LotteryPrize.SECOND.getCount());
        assertEquals(0, LotteryPrize.THIRD.getCount());
        assertEquals(0, LotteryPrize.FOURTH.getCount());
        assertEquals(1, LotteryPrize.FIFTH.getCount());
    }

    @Test
    public void testGetProfit() {
        assertEquals(0, LotteryPrize.FIRST.getProfit());
        assertEquals(0, LotteryPrize.SECOND.getProfit());
        assertEquals(0, LotteryPrize.THIRD.getProfit());
        assertEquals(0, LotteryPrize.FOURTH.getProfit());
        assertEquals(0, LotteryPrize.FIFTH.getProfit());
    }
}