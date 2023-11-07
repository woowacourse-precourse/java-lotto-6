package lotto;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoPrizeTest {

    @Test
    void toStringTest() {
        assertEquals("3개 일치 (5,000원) - 0개",LottoPrize.FIFTH.toString());
        assertEquals("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",LottoPrize.SECOND.toString());
    }

    @Test
    void increaseCountTest() {
        assertEquals("3개 일치 (5,000원) - 0개",LottoPrize.FIFTH.toString());
        LottoPrize.FIFTH.increaseCount();
        assertEquals("3개 일치 (5,000원) - 1개",LottoPrize.FIFTH.toString());
    }
}
