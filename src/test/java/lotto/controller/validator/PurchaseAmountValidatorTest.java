package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import lotto.controller.validator.PurchaseAmountValidator;
import lotto.utils.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurchaseAmountValidatorTest {
    private PurchaseAmountValidator purchaseAmountValidator;

    @BeforeEach
    public void setUp() {
        purchaseAmountValidator = new PurchaseAmountValidator();
    }

    @Test
    public void testValidPurchaseAmount() {
        assertThatCode(() -> purchaseAmountValidator.validate("2000"))
                .doesNotThrowAnyException();
    }

    @Test
    public void testNotNumber() {
        assertThatThrownBy(() -> purchaseAmountValidator.validate("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.NON_NUMERIC_EXCEPTION_MESSAGE);
    }

    @Test
    public void testZeroInput() {
        assertThatThrownBy(() -> purchaseAmountValidator.validate("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.ZERO_EXCEPTION_MESSAGE);
    }

    @Test
    public void testNonDivisibleBy1000() {
        assertThatThrownBy(() -> purchaseAmountValidator.validate("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.INDIVISIBLE_BY_UNIT_PRICE_EXCEPTION_MESSAGE);
    }
}