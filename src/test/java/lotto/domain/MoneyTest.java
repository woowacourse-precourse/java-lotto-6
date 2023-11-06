package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("구매 금액이 숫자로 구성되지 않았을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"a,", "1000a", " 1000"})
    void createMoneyByNotNumber(String userInput) {
        assertThatThrownBy(() -> new Money(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 양수 이외의 숫자일 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"1000.0,", "200.1", "0","-1000"})
    void createMoneyByNotPositiveNumber(String userInput) {
        assertThatThrownBy(() -> new Money(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 앞에 0이 포함될 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"01000", "00300"})
    void createMoneyByFirstNumberZero(String userInput) {
        assertThatThrownBy(() -> new Money(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000단위가 아닐 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"999", "1500","1001"})
    void createMoneyByNotThousands(String userInput) {
        assertThatThrownBy(() -> new Money(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}