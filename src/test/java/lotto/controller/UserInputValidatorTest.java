package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserInputValidatorTest {
    @DisplayName("구매 금액은 양의 정수여야 한다.")
    @Test
    void testNegativeBuyingPrice() {
        assertThatThrownBy(() -> UserInputValidator.isValidBuyingPrice("-3000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 금액은 양의 정수여야 합니다.");

        assertThatThrownBy(() -> UserInputValidator.isValidBuyingPrice("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 금액은 양의 정수여야 합니다.");
    }

    @DisplayName("구매 금액은 1000원 단위여야 한다..")
    @Test
    void testBuyingPrice() {
        assertThatThrownBy(() -> UserInputValidator.isValidBuyingPrice("1400"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 금액은 1000원 단위여야 합니다.");

    }
}