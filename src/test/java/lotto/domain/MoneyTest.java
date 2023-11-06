package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("구매 금액이 숫자로 구성되지 않았을 때, 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"a,", "1000a", " 1000"})
    void createMoneybyNotNumber(String userInput) {

        assertThatThrownBy(() -> new Money(userInput))
                .isInstanceOf(IllegalArgumentException.class);

    }

}