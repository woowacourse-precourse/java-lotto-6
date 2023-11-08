package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberUtilTest {

    @Test
    void calculateReturnRatio() {
        Float initialValue = (float) 8000;
        Float finalValue = (float) 5000;

        Float returnRatio = NumberUtil.calculateReturnRatio(initialValue, finalValue);
        Float expected = 62.5f;

        assertThat(returnRatio).isEqualTo(expected);
    }
}