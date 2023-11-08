package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("Money가 1000원으로 나누어 떨어지지 않으면 예외 처리")
    @Test
    void divideByThousandTest() {
        assertThatThrownBy(() -> new Money(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Money가 1000원보다 적으면 예외 처리")
    @Test
    void isOverThousandTest() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Money 생성 테스트")
    @Test
    void makeMoneyTest() {
        int money = 8000;
        Money moneyTest = Money.makeMoney(money);
        assertThat(money).isEqualTo(moneyTest.getMoney());
    }
}
