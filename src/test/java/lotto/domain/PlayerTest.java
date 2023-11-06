package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @DisplayName("로또 구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputLottoPurchaseAmountByType() {
        assertThatThrownBy(() -> new Player().setPurchaseAmount("one"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void inputLottoPurchaseAmountByDivided() {
        assertThatThrownBy(() -> new Player().setPurchaseAmount("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}