package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("구입 금액을 입력하면 입력한 금액을 가진 객체가 생성된다.")
    @Test
    void shouldCreateMoneyWithValidInputAmount() {
        Money money = new Money("1000");

        assertThat(money.amount()).isEqualTo(1000);
    }

    @DisplayName("숫자 이외의 다른 문자나 특수문자를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,000", "1_000", "1000.000", "천원", "$1"})
    void throwsExceptionForInvalidCharactersInAmount(String inputAmount) {
        assertThatThrownBy(() -> new Money(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다. ")
    @ParameterizedTest
    @ValueSource(strings = {"10", "100", "1500", "10001"})
    void throwsExceptionForAmountNotMultipleOfThousand(int inputAmount) {
        assertThatThrownBy(() -> new Money(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("최소 구입 금액인 1000원 미만 입력시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"500", "0", "-1000"})
    void throwsExceptionForAmountBelowMinimum() {
        String inputAmount = "-1000";

        assertThatThrownBy(() -> new Money(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("최대 구입 금액인 10만원 초과 입력시 예외가 발생한다.")
    @Test
    void throwsExceptionForAmountAboveMaximum() {
        String inputAmount = "1_001_000";

        assertThatThrownBy(() -> new Money(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}