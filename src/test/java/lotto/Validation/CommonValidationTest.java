package lotto.Validation;

import static lotto.Message.ExceptionMessage.CommonValidationErrorMessage.*;
import static org.junit.jupiter.api.Assertions.*;

import lotto.Exception.CommonValidationException;
import lotto.Message.ExceptionMessage.CommonValidationErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommonValidationTest {

    CommonValidation commonValidation;

    @BeforeEach
    void setUp() {
        commonValidation = new CommonValidation();
    }

    @Test
    @DisplayName("숫자가 범위 밖에 있을때 예외가 발생하는지 확인하는 테스트")
    void isValidRange() {
        //given
        Integer value1 = 0;
        Integer value2 = 46;

        //when, then
        Assertions.assertThatThrownBy(() -> commonValidation.isValidRange(value1))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(RANGE_ERROR_MESSAGE.getMessage(value1));

        Assertions.assertThatThrownBy(() -> commonValidation.isValidRange(value2))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(RANGE_ERROR_MESSAGE.getMessage(value2));
    }

    @Test

    void isBlank() {
    }

    @Test
    void isInteger() {
    }
}