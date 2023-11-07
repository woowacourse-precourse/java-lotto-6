package lotto.model;

import lotto.configuration.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    private static final int ERROR_INPUT = Constants.Rule.PRICE + 1;

    @Test
    @DisplayName("로또 가격으로 나누어 떨어지지 않으면 에러가 발생한다.")
    public void createMoneyByNotMultipleOfPrice() {
        //when & then
        assertThatThrownBy(() -> new Money(ERROR_INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }
}