package lotto.money;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("1000으로 나누어 떨어지지 않는 돈을 받으면 예외가 발생")
    @ValueSource(strings = {"100", "2300"})
    @ParameterizedTest
    void getIndivisibleMoney(String money) {
        Assertions.assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
