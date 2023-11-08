package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("구입 금액이 0인 경우 예외가 발생한다.")
    @Test
    void creatPurchaseMoneyZero() {
        assertThatThrownBy(() -> new Money("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void creatPurchaseMoneyNotNumber() {
        assertThatThrownBy(() -> new Money("abcd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void creatPurchaseMoneyNotDivide1000() {
        assertThatThrownBy(() -> new Money("12345"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
