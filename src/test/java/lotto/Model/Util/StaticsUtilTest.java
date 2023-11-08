package lotto.Model.Util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.Model.Domain.Lotto;
import lotto.Model.Domain.Raffle;
import org.junit.jupiter.api.Test;

class StaticsUtilTest {

    private final StaticsUtil staticsUtil = new StaticsUtil();

    @Test
    void calculateRevenue() {
        int purchaseMoney = 3000;
        int totalPrize = 15000;
        float result = 500F;

        assertEquals(result, staticsUtil.calculateRevenue(purchaseMoney, totalPrize));
    }

    @Test
    void drawResult() {
        Lotto lotto = new Lotto(Arrays.stream(new Integer[] {1,2,3,4,5,6}).toList());
        Raffle raffle = new Raffle(Arrays.stream(new Integer[] {1,2,3,4,5,6}).toList(), 7);
        int expectedResult = 6;

        assertEquals(expectedResult, staticsUtil.drawResult(lotto, raffle));
    }

    @Test
    void drawBonusNumberResult() {
        Lotto lotto = new Lotto(Arrays.stream(new Integer[] {1,2,3,4,5,7}).toList());
        int bounsNumber = 7;
        boolean expectedResult = true;

        assertEquals(expectedResult, staticsUtil.drawBonusNumberResult(lotto, bounsNumber));
    }
}