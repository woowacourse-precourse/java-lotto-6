package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class UtilTest {

    @Nested
    class CalculateYield {
        @ParameterizedTest
        @CsvSource(value = {
                "8000, 5000, 62.5",
                "5000, 5000, 100",
                "10000, 5000, 50",
                "50000, 0, 0",
                "1500000, 1500000, 100"
        })
        void 수익률을_잘_계산하는지_테스트(float before, float after, float expected) {
            Assertions.assertThat(Util.calculateYield(before, before + after)).isEqualTo(expected);
        }
    }

    @Nested
    class FormatFloat {
        @ParameterizedTest
        @CsvSource(value = {
                "84.13: 1: 84.1",
                "817.47: 1:817.5",
                "123023.78: 1: 123,023.8"
        }, delimiter = ':')
        void 형식에_맞추어_소수_첫쨰자리에서_반환하는지_테스트(float target, int precision, String expected) {
            Assertions.assertThat(Util.makeFloatFormattedYield(target, precision)).isEqualTo(expected);
        }
    }
}