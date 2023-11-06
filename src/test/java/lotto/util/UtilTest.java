package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Nested
    class CalculateYield{
        @ParameterizedTest
        @CsvSource(value = {
                "8000, 5000, 62.5",
                "5000, 5000, 100",
                "10000, 5000, 50",
                "50000, 0, 0",
                "1500000, 1500000, 100"
        })
        void 수익률을_잘_계산하는지_테스트(float before, float after, float expected){
            Assertions.assertThat(Util.calculateYield(before, after)).isEqualTo(expected);
        }
    }
}