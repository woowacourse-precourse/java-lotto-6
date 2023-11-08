package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("구입 금액의 값이 null이 들어온다면 예외가 발생한다.")
    @Test
    void createMoneyByNull() {
        assertThatThrownBy(() -> new Money(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액의 값이 음수가 들어온다면 예외가 발생한다.")
    @Test
    void createMoneyByNegativeNumber() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액의 값이 1.000원으로 나누어 떨어지지 않는다면 예외가 발생한다.")
    @Test
    void createMoneyByNumberNonDividedBy1000() {
        assertThatThrownBy(() -> new Money(10001))
                .isInstanceOf(IllegalArgumentException.class);
    }

}