package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CashierTest {
    @DisplayName("구입 금액을 0부터 9까지 숫자가 아닌 문자를 포함하여 입력하면 예외가 발생한다.")
    @Test
    void createCashierByNotDigitCharacter() {
        assertThatThrownBy(() -> new Cashier("1000원"))
                .isInstanceOf(IllegalArgumentException.class).isExactlyInstanceOf(NotDigitException.class);
    }

    @DisplayName("구입 금액이 1,000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void createCashierByNumberThatIsNotDivisibleByThousand() {
        assertThatThrownBy(() -> new Cashier("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}