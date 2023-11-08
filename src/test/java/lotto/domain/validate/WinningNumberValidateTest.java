package lotto.domain.validate;

import lotto.domain.validate.exception.InputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    @Test
    void 당첨_번호_입력_중복예외() {
        String duplicatedInput = "1,2,2,4,5,6";

        assertThatThrownBy(() -> inputValidator.validateWinningNumber(duplicatedInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.NOT_DISTINCTNESS.getMessage());
    }

    @Test
    void 당첨_번호_입력_범위예외() {
        String outRangeInput = "46,102,2,4,5,6";

        assertThatThrownBy(() -> inputValidator.validateWinningNumber(outRangeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.NOT_IN_RANGE_LOTTO_NUMBER.getMessage());
    }

    @Test
    void 당첨_번호_입력_문자예외() {
        String duplicatedInput = "1,2,3,4,5,a";

        assertThatThrownBy(() -> inputValidator.validateWinningNumber(duplicatedInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.NO_NUMBER.getMessage());
    }
}
