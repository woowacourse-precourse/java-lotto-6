package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBuyerTest {
    @DisplayName("로또 금액이 숫자가 아닌 경우 예외가 발생한다")
    @Test
    void inputNotNumberAmount() {
        assertThatThrownBy(() -> new LottoBuyer().buyLotto("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생")
    @Test
    void inputNotDividedUpAmount() {
        assertThatThrownBy(() -> new LottoBuyer().buyLotto("10001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생")
    @Test
    void inputNotPositiveNumber() {
        assertThatThrownBy(() -> new LottoBuyer().buyLotto("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
