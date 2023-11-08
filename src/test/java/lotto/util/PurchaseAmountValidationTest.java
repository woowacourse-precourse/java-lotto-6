package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountValidationTest {

    @Test
    @DisplayName("금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void divisibleThousand() {
        assertThatThrownBy(() -> PurchaseAmountValidation.divisibleThousand("1001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000으로 나누어 떨어져야 합니다.");
    }
}