package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class LottosResultTest {

    @Test
    void 수익률_구하기() {
        LottosResult lottosResult = new LottosResult();
        lottosResult.put(Winner.FRIST, 1);
        int investment = 1000;
        BigDecimal rateOfReturn = lottosResult.calculateRateOfReturn(investment);
        double expected = Winner.FRIST.getWinningMoney() / (double) investment * 100;
        assertEquals(expected, rateOfReturn.doubleValue());
    }

}