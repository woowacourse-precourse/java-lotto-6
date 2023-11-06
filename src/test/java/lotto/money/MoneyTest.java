package lotto.money;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("1000으로 나누어 떨어지지 않는 돈을 받으면 예외가 발생")
    @ValueSource(strings = {"100", "2300"})
    @ParameterizedTest
    void getIndivisibleMoney(String money) {
        Assertions.assertThatThrownBy(() -> new Money(money))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수로 금액을 입력하지 않으면 예외가 발생")
    @ValueSource(strings = {"ab", "10.5", "0.8"})
    @ParameterizedTest
    void getNotIntegerMoney(String money) {
        Assertions.assertThatThrownBy(() -> new Money(money))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액은 1000원 이상 입력하지 않으면 예외가 발생")
    @ValueSource(strings = {"0", "-1000"})
    @ParameterizedTest
    void getMoneyBelowMinimum(String money) {
        Assertions.assertThatThrownBy(() -> new Money(money))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전체 상금으로 수익률을 계산한다.")
    @Test
    void calculateProfit() {
        Money money = new Money("10000");
        Integer totalPrice = 12055;

        Double profit = money.calculateProfit(totalPrice);

        Assertions.assertThat(profit).isEqualTo(120.6);

    }
}
