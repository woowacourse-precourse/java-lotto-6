package lotto.CommonValidation;

import static lotto.CommonValidation.CommonValidation.hasBlank;
import static lotto.CommonValidation.CommonValidation.isInteger;
import static lotto.CommonValidation.CommonValidation.isValidLottoNumber;
import static lotto.Message.ExceptionMessage.CommonValidationErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

import lotto.Exception.CommonValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommonValidationTest {

    @Test
    @DisplayName("숫자가 범위 밖에 있을때 예외가 발생하는지 확인하는 테스트")
    void isValidRangeTest1() {
        //given
        Integer value1 = 0;
        Integer value2 = 46;

        //when, then
        assertThatThrownBy(() -> isValidLottoNumber(value1))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(RANGE_ERROR_MESSAGE.getMessage(value1));

        assertThatThrownBy(() -> isValidLottoNumber(value2))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(RANGE_ERROR_MESSAGE.getMessage(value2));
    }


    @Test
    @DisplayName("숫자가 범위 안에 있을때 정상 수행하는지 확인하는 테스트")
    void isValidRangeTest2() {
        //given
        Integer value1 = 1;
        Integer value2 = 45;

        //when
        isValidLottoNumber(value1);
        isValidLottoNumber(value2);

        //then
        assertThat(true).isTrue();
    }

    @Test
    @DisplayName("공백이 있을때 예외가 발생하는지 확인하는 테스트")
    void isBlankTest1() {
        //given
        String value = " ";

        //when
        assertThatThrownBy(() -> hasBlank(value))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(BLANK_VALUE_ERROR_MESSAGE.getMessage(value));
    }

    @Test
    @DisplayName("공백이 없을때 정상 동작하는지에 대한 테스트")
    void isBlankTest2() {
        //given
        String value = "1";

        //when
        hasBlank(value);

        //then
        assertThat(true).isTrue();
    }

    @Test
    @DisplayName("정수가 아닐때 예외가 발생하는지 확인하는 테스트")
    void isIntegerTest1() {
        //given
        String value1 = "1.1";
        String value2 = "a";

        //when
        assertThatThrownBy(() -> isInteger(value1))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(INTEGER_VALUE_ERROR_MESSAGE.getMessage(value1));

        //then
        assertThatThrownBy(() -> isInteger(value2))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(INTEGER_VALUE_ERROR_MESSAGE.getMessage(value2));
    }

    @Test
    @DisplayName("정수일때 정상 동작하는지에 대한 테스트")
    void isIntegerTest2() {
        //given
        String value = "1";

        //when
        isInteger(value);

        //then
        assertThat(true).isTrue();
    }
}