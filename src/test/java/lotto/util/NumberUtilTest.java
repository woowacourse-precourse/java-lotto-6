package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberUtilTest {

    @Test
    void calculateReturnRatio() {
        Double initialValue = (double) 8000;
        Double finalValue = (double) 5000;

        Double returnRatio = NumberUtil.calculateReturnRatio(initialValue, finalValue);
        Double expected = 0.625;

        assertThat(returnRatio).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"62.45:62.5", "62.449:62.4", "62.50:62.5", "62.511:62.5"}, delimiter = ':')
    void roundToTwoDecimalPlaces(Double input, Double expected) {
        Double converted = NumberUtil.roundToTwoDecimalPlaces(input);

        assertThat(converted).isEqualTo(expected);
    }
}