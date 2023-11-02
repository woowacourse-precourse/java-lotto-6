package lotto.Util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    @DisplayName("null 혹은 빈값 유효성 검사 테스트")
    public void isNullOrEmptyTest() {
        String nullValue = null;
        String empty = "";

        Throwable nullException = assertThrows(IllegalArgumentException.class,
            () -> Validator.validateNullOrEmpty(nullValue));
        assertTrue(nullException.getMessage().contains(Validator.NULL_OR_EMPTY_MESSAGE));

        Throwable emptyException = assertThrows(IllegalArgumentException.class,
            () -> Validator.validateNullOrEmpty(empty));
        assertTrue(emptyException.getMessage().contains(Validator.NULL_OR_EMPTY_MESSAGE));
    }
}
