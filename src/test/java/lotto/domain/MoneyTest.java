package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("구매금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByInavalidAmount() {
        assertThatThrownBy(() -> new Money(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 0원 이면 예외가 발생한다.")
    @Test
    void createMoneyByZero() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액만큼 갯수를 반환한다.")
    @Test
    void countNumberOfLottoByAmount() {
        int result = new Money(14000).countNumberOfLotto();
        assertThat(result).isEqualTo(14);
    }

}