package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.IllegalAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    private static final Integer UNDER_MIN_VALUE = 500;
    private static final Integer MIXED_VALUE = 5500;

    @DisplayName("단위 금액이 1000원 이하라면 예외를 발생한다.")
    @Test
    void validateMinimumAmount() {
        assertThatThrownBy(() -> NumberValidator.validateMinimumAmount(UNDER_MIN_VALUE))
                .isInstanceOf(IllegalAmountException.class);
        assertThatThrownBy(()->NumberValidator.validateMinimumAmount(MIXED_VALUE))
                .isInstanceOf(IllegalAmountException.class);
    }
}