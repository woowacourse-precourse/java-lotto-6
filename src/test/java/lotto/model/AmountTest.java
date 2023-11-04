package lotto.model;

import static lotto.util.message.Error.MUST_MONEY_UNIT;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AmountTest {

    private Amount amount;

    @ParameterizedTest
    @CsvSource({"0", "700", "7777", "12500"})
    @DisplayName("구매 금액은 1,000원 단위만 가능하다.")
    public void inputMoneyValidate(int input) {
        Assertions.assertThatThrownBy(() -> new Amount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MUST_MONEY_UNIT);
    }
}