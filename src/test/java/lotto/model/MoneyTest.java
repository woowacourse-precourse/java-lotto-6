package lotto.model;

import static lotto.util.TestUtil.ERROR_PREFACE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("돈이 마이너스 금액이면 예외가 발생한다.")
    @Test
    void createMoneyByMinusAmount() {
        assertThatThrownBy(() -> new Money("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFACE);
    }

    @DisplayName("돈이 0원이면 예외가 발생한다. 0원은 지불할 수 없다.")
    @Test
    void createMoneyByZeroAmount() {
        assertThatThrownBy(() -> new Money("-0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFACE);
    }

    @DisplayName("돈이 정상적으로 입력되면 값이 잘 저장된다.")
    @Test
    void createMoneySuccess() {
        // given
        final int number = 1000;

        // when
        Money money = new Money(String.valueOf(number));

        // then
        assertThat(money.getMoney()).isEqualTo(number);
    }

}