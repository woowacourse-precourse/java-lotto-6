package lotto.domain.validate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class WinningNumberValidateTest {
    InputValidator inputValidator;

    @BeforeEach
    void SetUp() {
        inputValidator = new InputValidator();
    }

    @Test
    void 당첨_번호_입력_성공() {
        String validatedInput = "1,2,3,4,5,6";

        assertDoesNotThrow(() -> inputValidator.validateWinningNumber(validatedInput));
    }
}
