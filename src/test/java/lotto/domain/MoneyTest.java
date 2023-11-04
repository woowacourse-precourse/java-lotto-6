package lotto.domain;

import lotto.domain.money.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 100000})
    void 금액을_입력하면_금액_객체_생성(int amount) {
        Money money = new Money(amount);
    }

    @Test
    void 금액이_0원이면_예외_발생() {
        int amount = 0;
        Assertions.assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ");
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 1234, 104051})
    void 금액이_1000원_단위로_나누어_떨어지지_않으면_예외_발생(int amount) {
        Assertions.assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ");
    }

}
