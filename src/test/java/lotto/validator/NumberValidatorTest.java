package lotto.validator;

import static lotto.exception.Exception.INVALID_NUMBER_RANGE;
import static lotto.validator.NumberValidator.validateRange;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {
    @DisplayName("번호가 1부터 45 범위에 벗어난 경우 예외가 발생하는가.")
    @Test
    void validateNumberByOverRange() {
        int outRangeNumber = 50;

        assertThatThrownBy(() -> validateRange(outRangeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_RANGE.getMessage());
    }
}
