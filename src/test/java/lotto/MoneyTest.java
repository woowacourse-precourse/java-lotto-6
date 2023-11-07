package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void moneyIsNumber() {
        assertThatThrownBy(() -> new Money("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void moneyIsDivide() {
        assertThatThrownBy(() -> new Money("3001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 빈칸이면 예외가 발생한다.")
    @Test
    void moneyIsEmpty() {
        assertThatThrownBy(() -> new Money(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원 이하라면 예외가 발생한다.")
    @Test
    void moneyIsBigger() {
        assertThatThrownBy(() -> new Money("800"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
