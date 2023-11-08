package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VerifierTest {
    @DisplayName("구입 금액이 1000보다 작으면 예외가 발생한다.")
    @Test
    void validatePurchaseAmountByLessThan1000() {
        assertThatThrownBy(() -> Verifier.validatePurchaseAmount(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void validatePurchaseAmountByNotMultipleOf1000() {
        assertThatThrownBy(() -> Verifier.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 ,로 구분되지 않으면 예외가 발생한다.")
    @Test
    void validateWinningNumbersByNotComma() {
        assertThatThrownBy(() -> Verifier.validateWinningNumbers("1 2 3 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아니면 예외가 발생한다.")
    @Test
    void validateOnlyNumberByNotNumber() {
        assertThatThrownBy(() -> Verifier.validateOnlyNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
