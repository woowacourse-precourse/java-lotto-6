package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import lotto.model.Money;
import lotto.calculators.ProfitRateCalculators;
import org.junit.jupiter.api.Test;

class ProfitRateCalculatorsTest {

    @Test
    void normal() {
        ProfitRateCalculators profitRateCalculators = new ProfitRateCalculators(new Money(8000), BigDecimal.valueOf(5000));

        assertEquals(profitRateCalculators.getProfitRate(), BigDecimal.valueOf(62.5)+"%");
    }
}