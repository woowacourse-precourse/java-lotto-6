package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.MoneyFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    @DisplayName("올바른 구매 금액")
    @CsvSource({"1000", "19000", "1010000", "99000"})
    @ParameterizedTest
    public void createMoney(String amount) {
        new Money(Integer.parseInt(amount));
    }

    @DisplayName("구매 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @CsvSource({"1100", "13040", "11111"})
    @ParameterizedTest
    public void createMoneyNotModUnit(String amount) {
        assertThatThrownBy(() -> new Money(Integer.parseInt(amount))).isInstanceOf(
                MoneyFormatException.class);
    }

    @DisplayName("구매 금액이 1,000원 미만이면 예외가 발생한다.")
    @CsvSource({"-10", "0", "11", "999"})
    @ParameterizedTest
    public void createMoneyUnderUnit(String amount) {
        assertThatThrownBy(() -> new Money(Integer.parseInt(amount))).isInstanceOf(
                MoneyFormatException.class);
    }
}