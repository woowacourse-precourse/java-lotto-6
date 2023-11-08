package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @DisplayName("문자 입력하면 예외 발생")
    @Test
    void createAmountByString() {
        String input = "a";
        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자로만 이루어진 값을 입력해주세요.");
    }

    @DisplayName("1000으로 나누어 떨어지지 않으면 예외 발생")
    @Test
    void createAmountByWrongUnit() {
        String input = "1500";
        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 금액은 1,000원 단위여야 합니다.");
    }
}
