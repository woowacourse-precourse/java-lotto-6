package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMoneyTest {

    @DisplayName("구입 금액이 올바르지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "2500", "-1000"})
    void createLottoMoneyByInvalidInput(String input) {
        assertThatThrownBy(() -> new LottoMoney(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }
}