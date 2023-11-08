package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NumbersTest {
    Numbers numbers = new Numbers();

    @Test
    void putCommaInNumber_테스트() {
        final long input = 1000000;
        final String result = "1,000,000";

        assertThat(numbers.putCommaInNumber(Long.toString(input))).isEqualTo(result);
    }

    @Test
    void rateOfReturn_테스트() {
        final long reward = 135000;
        final long inputMoney = 500000;
        final double result = 27.0;

        assertThat(numbers.rateOfReturn(reward, inputMoney)).isEqualTo(result);
    }

}
