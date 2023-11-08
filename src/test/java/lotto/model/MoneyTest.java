package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {
    @DisplayName("금액은 문자열을 포함할 수 업고,금액 형식을 만족해야한다.")
    @ParameterizedTest(name = "잘못된 투입금액 : {0}")
    @CsvSource(value = {"100j","01234","fdcc"})
    void createMoneyByImproperString(String inputMoney) {
        assertThatThrownBy(() ->new Money(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 금액입니다.");
    }
}
