₩package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("금액에 숫자 이외의 값이 오면 예외가 발생한다.")
    @Test
    void createMoneyTestFromStringNotNumber() {
        assertThatThrownBy(() -> new Money("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 로또 금액과 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyTestFromStringNotDivide() {
        assertThatThrownBy(() -> new Money("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 자료형의 범위를 초과하면 예외가 발생한다.")
    @Test
    void createMoneyTestFromStringOverIntegerRance() {
        assertThatThrownBy(() -> new Money("2147484000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
