package lotto.validator;

import static lotto.Exception.INVALID_NUMBER_RANGE;
import static lotto.validator.NumberValidator.validateRange;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NumberValidatorTest {
    @Test
    void 보너스번호가_1부터_45_범위에_벗어난_경우() {
        int outRangeNumbers = 50;

        assertThatThrownBy(() -> validateRange(outRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_RANGE.getMessage());
    }
}
