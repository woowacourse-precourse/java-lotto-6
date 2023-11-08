package lotto.validationTest;
/*
public static void validateNaturalNumber(String input) {
    boolean isInteger = input.trim().matches("^[0-9]+$");
    if (!isInteger || Integer.parseInt(input) <= 0) {
        throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUMBER.getMessage());
    }
}

public static void validateNaturalNumber(List<String> input) {
    input.forEach(Validation::validateNaturalNumber);
}
 */

import lotto.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateNaturalNumberTest {
    @Test
    public void 입력에_문자_오류발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateNaturalNumber("a123"));
    }

    @Test
    public void 입력이_0만_오류발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateNaturalNumber("0000"));
    }

    @Test
    public void 입력에_음수기호_오류발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateNaturalNumber("-123"));
    }

    @Test
    public void 입력에_숫자만_오류발생안함() {
        Assertions.assertDoesNotThrow(
                () -> Validation.validateNaturalNumber("1234"));
    }
}
