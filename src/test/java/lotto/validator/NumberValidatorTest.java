package lotto.validator;

import static lotto.exception.Exception.INVALID_NUMBER_RANGE;
import static lotto.validator.NumberValidator.validateRange;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NumberValidatorTest {
    @Test
    void 번호가_1부터_45_범위에_벗어난_경우() {
        int outRangeNumber = 50;

        assertThatThrownBy(() -> validateRange(outRangeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_RANGE.getMessage());
    }
}
