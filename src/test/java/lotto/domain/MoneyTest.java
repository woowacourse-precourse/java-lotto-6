package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("잔액이 0보다 작으면 예외가 발생한다")
    void decreaseUntilZero() {
        //given
        int amount = 10000;
        Money money = Money.from(amount);
        //when
        int purchasedAmount = 10001;
        //then
        Assertions.assertThatThrownBy(() -> money.decrease(purchasedAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 음수가 될 수 없습니다.");
    }
}