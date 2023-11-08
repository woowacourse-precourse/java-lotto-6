package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("1000보다 작은 금액 입력 시 예외가 발생한다.")
    @Test
    void inputMoneyUnderThousandTest() {
        assertThatThrownBy(() -> new Money().inputMoney("900"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void inputMoneyDivideTest() {
        assertThatThrownBy(() -> new Money().inputMoney("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputMoneyNumericValidateTest() {
        assertThatThrownBy(() -> new Money().inputMoney("million"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}