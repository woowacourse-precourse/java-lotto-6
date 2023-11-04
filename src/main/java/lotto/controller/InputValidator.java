package lotto.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidator {
    @Test
    @DisplayName("구입 금액이 숫자가 아닐 때 예외를 던진다")
    void validatePurchaseAmount_NotANumber_ThrowsException() {
        String input = "9천9백원";

        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 숫자여야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 정수 범위가 아닐 때 예외를 던진다")
    void validatePurchaseAmount_NotANumber_ThrowsException() {
        String input = "1234567890";

        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 정수 허용값 범위 내여야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 1000원 미만일 때 예외를 던진다")
    void validatePurchaseAmount_LessThanMinimum_ThrowsException() {
        String input = "500";

        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1000원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닐 때 예외를 던진다")
    void validatePurchaseAmount_NotAThousandUnit_ThrowsException() {
        String input = "2500";

        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1000원 단위여야 합니다.");
    }
}
