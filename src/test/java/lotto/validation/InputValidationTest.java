package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {
    InputValidation inputValidation = new InputValidation();

    @Test
    void validatePurchasingAmountTest_success() {
        //given
        String inputNumber = "8000";

        //when
        boolean result = inputValidation.validatePurchasingAmount(inputNumber);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    void validatePurchasingAmountTest_exception() {
        Assertions.assertThatThrownBy(() -> inputValidation.validatePurchasingAmount("8100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinningNumbersTest_success() {
        //given
        String numbers = "42,13,5,19,18,37";

        //when
        boolean result = inputValidation.validateWinningNumber(numbers);

        //then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void validateWinningNumbersTest_exception() {
        Assertions.assertThatThrownBy(() -> inputValidation.validateWinningNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumberTest_success() {
        //given
        String number = "45";
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        //when
        boolean result = inputValidation.validateBonusNumber(numbers, number);

        //then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void validateBonusNumberTest_exception() {
        //given
        List<Integer> numbers = Arrays.asList(2, 15, 19, 21, 33, 42);

        //when
        String bonusNumber = "15";

        //then
        Assertions.assertThatThrownBy(() -> inputValidation.validateBonusNumber(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}