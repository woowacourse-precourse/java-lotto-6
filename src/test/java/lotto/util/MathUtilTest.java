package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.util.MathUtil.formatPercentage;

class MathUtilTest {
    @Test
    @DisplayName("실수가 주어졌을 때, 소수점 둘째 자리에서 반올림하여 리턴")
    void testFormatPercentage() {
        // given
        double profit1 = 100.0;
        double profit2 = 51.5;
        double profit3 = 1000000.0;

        // when
        String formattedProfit1 = formatPercentage(100,profit1);
        String formattedProfit2 = formatPercentage(100,profit2);
        String formattedProfit3 = formatPercentage(100,profit3);

        // then
        Assertions.assertThat(formattedProfit1).isEqualTo("100.0%");
        Assertions.assertThat(formattedProfit2).isEqualTo("51.5%");
        Assertions.assertThat(formattedProfit3).isEqualTo("1,000,000.0%");
    }

}