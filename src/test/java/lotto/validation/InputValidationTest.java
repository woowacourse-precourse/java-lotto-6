package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
        String numbers = "1,2,3,4,5,6";

        //when
        boolean result = inputValidation.validateBonusNumber(numbers, number);

        //then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void validateBonusNumberTest_exception() {
        Assertions.assertThatThrownBy(() -> inputValidation.validateBonusNumber("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}