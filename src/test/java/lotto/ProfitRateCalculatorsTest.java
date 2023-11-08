package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import lotto.model.Money;
import lotto.calculators.ProfitRateCalculators;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProfitRateCalculatorsTest {

    @Test
    void normal() {
        ProfitRateCalculators profitRateCalculators = new ProfitRateCalculators(new Money(8000), BigDecimal.valueOf(5000));

        assertEquals(profitRateCalculators.getProfitRate(), (double) 62.5);
    }

    @ParameterizedTest
    @CsvSource({
            "5000, 5000, 100.0",
            "2000, 3000, 150.0",
            "10000, 7000, 70.0",
            "3000, 2900, 96.7",
            "7500, 9000, 120.0",
            "2500, 2500, 100.0",
            "4500, 4000, 88.9",
            "8000, 5000, 62.5",
            "7000, 5000, 71.4",
            "3500, 35000, 1000.0"
    })
    void normal2(int money, long totalPrize, double profitRate ) {
        ProfitRateCalculators profitRateCalculators = new ProfitRateCalculators(new Money(money), BigDecimal.valueOf(totalPrize));

        assertEquals(profitRateCalculators.getProfitRate(), profitRate, 0.1);
    }
}