package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeCalculatorTest {

    @DisplayName("1000원 수익률 계산 테스트")
    @Test
    void calculateRateOfReturn(){
        Amount amount = new Amount(1000);
        WinningResult winningResult = new WinningResult();

        winningResult.addResults(6,false);
        double rateOfReturn = PrizeCalculator.getRateOfReturn(winningResult, amount);

        Assertions.assertEquals((double)2000000000/10, rateOfReturn);
    }


}
