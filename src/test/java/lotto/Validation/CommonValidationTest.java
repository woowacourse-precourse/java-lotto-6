package lotto.Validation;

import static lotto.Message.ExceptionMessage.CommonValidationErrorMessage.*;
import static org.assertj.core.api.Assertions.*;
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
    void isValidRange1() {
        //given
        Integer value1 = 0;
        Integer value2 = 46;

        //when, then
        assertThatThrownBy(() -> commonValidation.isValidRange(value1))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(RANGE_ERROR_MESSAGE.getMessage(value1));

        assertThatThrownBy(() -> commonValidation.isValidRange(value2))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(RANGE_ERROR_MESSAGE.getMessage(value2));
    }


    @Test
    @DisplayName("숫자가 범위 안에 있을때 정상 수행하는지 확인하는 테스트")
    void isValidRange2() {
        //given
        Integer value1 = 1;
        Integer value2 = 45;

        //when
        commonValidation.isValidRange(value1);
        commonValidation.isValidRange(value2);

        //then
        assertThat(true).isTrue();
    }

    @Test
    @DisplayName("공백이 있을때 예외가 발생하는지 확인하는 테스트")
    void isBlank1() {
        //given
        String value = " ";

        //when
        assertThatThrownBy(() -> commonValidation.isBlank(value))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(BLANK_VALUE_ERROR_MESSAGE.getMessage(value));
    }

    @Test
    @DisplayName("공백이 없을때 정상 동작하는지에 대한 테스트")
    void isBlank2() {
        //given
        String value = "1";

        //when
        commonValidation.isBlank(value);

        //then
        assertThat(true).isTrue();
    }

    @Test
    @DisplayName("정수가 아닐때 예외가 발생하는지 확인하는 테스트")
    void isInteger() {
        //given
        String value1 = "1.1";
        String value2 = "a";

        //when
        assertThatThrownBy(() -> commonValidation.isInteger(value1))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(INTEGER_VALUE_ERROR_MESSAGE.getMessage(value1));

        //then
        assertThatThrownBy(() -> commonValidation.isInteger(value2))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(INTEGER_VALUE_ERROR_MESSAGE.getMessage(value2));
    }

    @Test
    @DisplayName("정수일때 정상 동작하는지에 대한 테스트")
    void isInteger2() {
        //given
        String value = "1";

        //when
        commonValidation.isInteger(value);

        //then
        assertThat(true).isTrue();
    }
}