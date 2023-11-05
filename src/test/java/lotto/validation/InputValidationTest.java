package lotto.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {

    InputValidation inputValidation = new InputValidation();

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    public void 빈문자열(String input) {
        //then (기능 작동 후 결과)
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                inputValidation.validationMoney(input));
    }
}