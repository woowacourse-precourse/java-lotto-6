package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.IllegalAmountException;
import lotto.exception.IllegalNumberTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    private static final Integer UNDER_MIN_VALUE = 500;
    private static final Integer MIXED_VALUE = 5500;
    private static final String NUMBERS_CONTAIN_TEXT = "1000S";
    private static final String NUMBERS_CONTAIN_SPACE = "10 00";
    private static final String NUMBERS_CONTAIN_SPECIAL_TEXT = "10#00";


    @DisplayName("단위 금액이 1000원 이하라면 예외를 발생한다.")
    @Test
    void validateMinimumAmount() {
        assertThatThrownBy(() -> NumberValidator.validateMinimumAmount(UNDER_MIN_VALUE))
                .isInstanceOf(IllegalAmountException.class);
        assertThatThrownBy(()->NumberValidator.validateMinimumAmount(MIXED_VALUE))
                .isInstanceOf(IllegalAmountException.class);
    }
    @DisplayName("입력된 문자열이 숫자가 아니면 예외를 발생한다.")
    @Test
    void validateNumberType() {
        assertThatThrownBy(()->NumberValidator.validateNumberType(NUMBERS_CONTAIN_TEXT))
                .isInstanceOf(IllegalNumberTypeException.class);
        assertThatThrownBy(()->NumberValidator.validateNumberType(NUMBERS_CONTAIN_SPACE))
                .isInstanceOf(IllegalNumberTypeException.class);
        assertThatThrownBy(()->NumberValidator.validateNumberType(NUMBERS_CONTAIN_SPECIAL_TEXT))
                .isInstanceOf(IllegalNumberTypeException.class);
        assertThatThrownBy(()->NumberValidator.validateNumberType(null))
                .isInstanceOf(IllegalNumberTypeException.class);
    }
}