package lotto.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import lotto.enums.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EarningRateCalculatorTest {

    @DisplayName("로또 구매 후 당첨 상금에 대한 수익률을 올바르게 계산")
    @Test
    public void testCalculateEarningRate() {

        int purchaseMoney = 8000;
        EnumMap<LottoPrize, Integer> prizes = new EnumMap<>(LottoPrize.class);
        prizes.put(LottoPrize.SECOND, 0);
        prizes.put(LottoPrize.THIRD, 0);
        prizes.put(LottoPrize.FOURTH, 0);
        prizes.put(LottoPrize.FIFTH, 1);

        BigDecimal result = EarningRateCalculator.calculate(prizes, purchaseMoney);
        BigDecimal expected = BigDecimal.valueOf(62.5).setScale(1, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }
}
