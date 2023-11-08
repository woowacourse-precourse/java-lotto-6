package lotto.CommonValidation;

import static lotto.CommonValidation.CommonValidation.hasBlank;
import static lotto.CommonValidation.CommonValidation.isInteger;
import static lotto.CommonValidation.CommonValidation.isValidLottoNumber;
import static lotto.Dictionary.LottoDictionary.LOTTO_MAX_NUMBER;
import static lotto.Dictionary.LottoDictionary.LOTTO_MIN_NUMBER;
import static lotto.Message.ExceptionMessage.CommonValidationErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

import lotto.Exception.CommonValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommonValidationTest {

    private final int invalidLottoNumber1 = 0;
    private final int invalidLottoNumber2 = 46;
    private final String whiteSpace = " ";
    private final String notInteger = "a";
    private final String realNumber = "1.1";
    private final String normalValue = "1";

    @Test
    @DisplayName("숫자가 범위 밖에 있을때 예외가 발생하는지 확인하는 테스트")
    void isValidRangeTest1() {
        //given

        //when, then
        assertThatThrownBy(() -> isValidLottoNumber(invalidLottoNumber1))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(RANGE_ERROR_MESSAGE.getMessage(invalidLottoNumber1));

        assertThatThrownBy(() -> isValidLottoNumber(invalidLottoNumber2))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(RANGE_ERROR_MESSAGE.getMessage(invalidLottoNumber2));
    }


    @Test
    @DisplayName("숫자가 범위 안에 있을때 정상 수행하는지 확인하는 테스트")
    void isValidRangeTest2() {
        //given

        //when
        isValidLottoNumber(LOTTO_MIN_NUMBER.getValue());
        isValidLottoNumber(LOTTO_MAX_NUMBER.getValue());

        //then
        assertThat(true).isTrue();
    }

    @Test
    @DisplayName("공백이 있을때 예외가 발생하는지 확인하는 테스트")
    void isBlankTest1() {
        //given

        //when
        assertThatThrownBy(() -> hasBlank(whiteSpace))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(BLANK_VALUE_ERROR_MESSAGE.getMessage(whiteSpace));
    }

    @Test
    @DisplayName("공백이 없을때 정상 동작하는지에 대한 테스트")
    void isBlankTest2() {
        //given
        //when
        hasBlank(normalValue);

        //then
        assertThat(true).isTrue();
    }

    @Test
    @DisplayName("정수가 아닐때 예외가 발생하는지 확인하는 테스트")
    void isIntegerTest1() {
        //given

        //when
        assertThatThrownBy(() -> isInteger(notInteger))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(INTEGER_VALUE_ERROR_MESSAGE.getMessage(notInteger));

        //then
        assertThatThrownBy(() -> isInteger(realNumber))
                .isInstanceOf(CommonValidationException.class)
                .hasMessageContaining(INTEGER_VALUE_ERROR_MESSAGE.getMessage(realNumber));
    }

    @Test
    @DisplayName("정수일때 정상 동작하는지에 대한 테스트")
    void isIntegerTest2() {
        //given

        //when
        isInteger(normalValue);

        //then
        assertThat(true).isTrue();
    }
}