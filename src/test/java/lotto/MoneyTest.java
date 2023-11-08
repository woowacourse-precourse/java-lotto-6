package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @Test
    @DisplayName("1000원 단위 금액 입력 테스트")
    void createValidInput() {
        Money money = new Money("91000");
        assertThat(money.getLottoCount()).isEqualTo(91);
    }

    @Test
    @DisplayName("입력 금액이 null인 예외 상황")
    void createNullMoneyInput() {
        assertThatThrownBy(() -> new Money(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null 입력 불가");
    }

    @Test
    @DisplayName("입력 금액이 공백인 예외 상황")
    void createBlankMoneyInput() {
        assertThatThrownBy(() -> new Money(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 금액은 입력 불가");
    }

    @Test
    @DisplayName("입력 금액이 숫자가 아닌 예외 상황")
    void createNotNumberInput() {
        assertThatThrownBy(() -> new Money("1391a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수만 입력 가능");
    }

    @Test
    @DisplayName("입력 금액이 양수가 아닌 예외 상황")
    void createNegativeIntegerInput() {
        assertThatThrownBy(() -> new Money("-1131"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 1000원 단위 양수만 가능");
    }

    @Test
    @DisplayName("입력 금액이 1000으로 나누어 떨어지지 않는 예외 상황")
    void createInvalidInput() {
        assertThatThrownBy(() -> new Money("4100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 1000원 단위 양수만 가능");
    }
}
