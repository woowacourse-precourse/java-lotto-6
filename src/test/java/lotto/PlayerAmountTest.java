package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.PlayerAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerAmountTest {

    @DisplayName("구매 금액이 1000단위로 나누어 떨어지면 테스트에 통과한다.")
    @Test
    public void inputPlayerAmountDivisible() {
        PlayerAmount playerAmount = new PlayerAmount("2000");

        int expectedCount = 2;
        int actualCount = playerAmount.getLottoCount();

        assertThat(actualCount).isEqualTo(expectedCount);

    }

    @DisplayName("구매 금액이 1000원 이하 일때 예외가 발생한다.")
    @Test
    public void inputPlayerAmountIsZero() {
        assertThatThrownBy(() -> new PlayerAmount("900"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("구매 금액이 1000단위로 나누어 떨어지지 않을때 예외가 발생한다.")
    @Test
    public void inputPlayerAmountNotDivisible() {
        assertThatThrownBy(() -> new PlayerAmount("1800"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
