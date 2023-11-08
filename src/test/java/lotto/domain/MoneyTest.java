package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTest {
    @DisplayName("구매 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1001, 9999, 10302})
    void createMoneyByNot1000Unit(int input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000원 단위인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {5000, 20000, 300000})
    void createMoneyBy1000Unit(int input) {
        Money money = new Money(input);
        assertEquals(money.value(), input);
    }
}