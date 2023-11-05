package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("1000원으로 나누어 떨어지지 않을 때 예외가 발생한다.")
    @Test
    void createMoneyByNotDivisible() {
        assertThatThrownBy(() -> Money.from(12060))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("충분한 돈이 없을 경우 예외가 발생한다.")
    @Test
    void createMoneyByNotEnough() {
        assertThatThrownBy(() -> Money.from(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
