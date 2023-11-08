package lotto.domain.validate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
