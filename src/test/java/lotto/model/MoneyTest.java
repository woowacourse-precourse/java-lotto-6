package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("구입 금액이 0원이하일 경우 예외 발생")
    @Test
    void createMoneyLessThanZero() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000원 단위가 아닌 경우 예외 발생")
    @Test
    public void createMoneyNotDividedByThousand() {
        assertThatThrownBy(() -> new Money(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
