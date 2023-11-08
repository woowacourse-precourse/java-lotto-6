package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("유틸_테스트")
class UtilsTest {

    @Test
    @DisplayName("숫자_포멧_테스트")
    void changeDecimalFormat() {
        long target = 1000000;
        String expected = "1,000,000";
        Assertions.assertThat(Utils.changeDecimalFormat(target)).isEqualTo(expected);
    }

    @Test
    @DisplayName("소수점_포멧_테스트")
    void changeDoubleFormat() {
        double target = 2000000;
        String expected = "2,000,000.0";
        Assertions.assertThat(Utils.changeDoubleFormat(target)).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률_계산_테스트")
    void calculateRateOfReturn() {
        double earnMoney = 5000;
        double spendMoney = 1000;
        double expected = 500.0;
        Assertions.assertThat(Utils.calculateRateOfReturn(earnMoney, spendMoney)).isEqualTo(expected);
    }
}