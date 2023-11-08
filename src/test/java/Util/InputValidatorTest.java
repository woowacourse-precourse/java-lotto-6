package Util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    void 음수_금액_입력() {
        assertThatThrownBy(() -> inputValidator.checkInputPurchaseAmount("-1234")).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 금액_0원_입력() {
        assertThatThrownBy(() -> inputValidator.checkInputPurchaseAmount("0")).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 금액_입력이_로또_가격으로_나누어_떨어지지않음() {
        assertThatThrownBy(() -> inputValidator.checkInputPurchaseAmount("1001")).isInstanceOf(
                IllegalArgumentException.class);
    }
}