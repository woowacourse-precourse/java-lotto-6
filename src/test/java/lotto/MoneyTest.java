package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("구입 금액 형식에 맞지 않으면 예외가 발생한다.")
    @Test
    void getMoneyByIllegalFormat() {
        assertThatThrownBy(() -> new Money("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000으로 나누어 떨이지지 않으면 예외가 발생한다.")
    @Test
    void getMoneyByIllegalNumberFormat() {
        assertThatThrownBy(() -> new Money("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000보다 작으면 예외가 발생한다.")
    @Test
    void getMoneyByLessThanMinAmount() {
        assertThatThrownBy(() -> new Money("20"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}