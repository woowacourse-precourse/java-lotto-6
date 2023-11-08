package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateOfReturnTest {
    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateRateOfReturn() {
        double profit = 5000;
        double investmentAmount = 10000;
        double expectedRate = profit / investmentAmount * RateOfReturn.PERCENT_MULTIPLIER; // 기대되는 수익률 계산

        RateOfReturn rateOfReturn = RateOfReturn.calculate(profit, investmentAmount);

        assertEquals(expectedRate, rateOfReturn.getRate(), 0.001);
    }
}

