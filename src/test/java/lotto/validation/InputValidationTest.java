package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {
    InputValidation inputValidation = new InputValidation();

    @Test
    void validatePurchasingAmountTest_exception() {
        Assertions.assertThatThrownBy(() -> inputValidation.validatePurchasingAmount("8100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateWinningNumbersTest_exception() {
        Assertions.assertThatThrownBy(() -> inputValidation.validateWinningNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumberTest_exception() {
        //given
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 15, 19, 21, 33, 42));

        //when
        String bonusNumber = "15";

        //then
        Assertions.assertThatThrownBy(() -> inputValidation.validateBonusNumber(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}