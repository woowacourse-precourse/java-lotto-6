package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.math.BigDecimal;
import java.util.List;
import lotto.model.WinningCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningCalculatorTest {
    private WinningCalculator winningCalculator;
    @BeforeEach
    void setup(){
        winningCalculator = new WinningCalculator();
        winningCalculator.setSales(10);
        winningCalculator.setTotalWinningMoney(new BigDecimal("2300000000"));
    }

    @Test
    void calculateRateOfReturnTest(){
        BigDecimal rateOfReturn = winningCalculator.calculateRateOfReturn();
        assertThat(rateOfReturn.toPlainString()).isEqualTo("23000000000");
    }
}
