package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void changeDecimalFormat() {
        long target = 1000000;
        String expected = "1,000,000";
        Assertions.assertThat(Utils.changeDecimalFormat(target)).isEqualTo(expected);
    }

    @Test
    void changeDoubleFormat() {
        double target = 2000000;
        String expected = "2,000,000.0";
        Assertions.assertThat(Utils.changeDoubleFormat(target)).isEqualTo(expected);
    }

    @Test
    void calculateRateOfReturn() {
        double earnMoney = 5000;
        double spendMoney = 1000;
        double expected = 500.0;
        Assertions.assertThat(Utils.calculateRateOfReturn(earnMoney, spendMoney)).isEqualTo(expected);
    }
}