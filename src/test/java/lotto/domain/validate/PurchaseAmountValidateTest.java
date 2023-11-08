package lotto.domain.validate;

import lotto.domain.validate.exception.InputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PurchaseAmountValidateTest {
    InputValidator inputValidator;

    @BeforeEach
    void SetUp() {
        inputValidator = new InputValidator();
    }

    @Test
    void 구입_금액_입력_성공() {
        String validatedInput = "10000";

        assertDoesNotThrow(() -> inputValidator.validatePurchaseAmount(validatedInput));
    }

    @Test
    void 구입_금액_입력_범위예외() {
        String outRangeInput = "1000000";

        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(outRangeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.NOT_IN_RANGE_MONEY.getMessage());
    }

    @Test
    void 구입_금액_입력_숫자예외() {
        String notNumberInput = "1j";

        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(notNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.NO_NUMBER.getMessage());
    }

    @Test
    void 구입_금액_입력_나머지예외() {
        String notDividedInput = "1200";

        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount(notDividedInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.NOT_DIVIDED_BY_1000.getMessage());
    }
}
