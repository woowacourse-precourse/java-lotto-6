package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import lotto.model.Money;
import lotto.model.ProfitRate;
import org.junit.jupiter.api.Test;

class ProfitRateTest {

    @Test
    void normal() {
        ProfitRate profitRate = new ProfitRate(new Money(8000), BigDecimal.valueOf(5000));

        assertEquals(profitRate.getProfitRate(), BigDecimal.valueOf(62.5)+"%");
    }
}