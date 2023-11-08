package lotto.validationTest;

import lotto.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/*
public static void validateNotNull(List<Integer> input) {
    if (input == null) {
        throw new IllegalArgumentException(ErrorMessage.NULL_ERROR.getMessage());
    }
}
*/
public class ValidateNotNullTest {
    @Test
    public void 입력이_NULL_오류발생() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validation.validateNotNull(null));
    }
    @Test
    public void 입력이_NULL이_아님_오류없음() {
        Assertions.assertDoesNotThrow(
                () -> Validation.validateNotNull(new ArrayList<>()));
    }
}
