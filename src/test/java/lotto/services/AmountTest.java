package lotto.services;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {

    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void createAmountNotDivisibleBy1000() {
        assertThatThrownBy(() -> new Amount().createAmount("13500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionHandler.NOT_DIVISIBLE);
    }
}