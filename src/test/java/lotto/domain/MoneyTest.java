package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0, 10, 100, 500, 1500})
    @DisplayName("금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    void makeMoneyByWrongUnit(int amount) {
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "1000,1",
            "2000,2",
            "5000,5",
            "10000,10",
    })
    @DisplayName("가격에 맞는 수량을 계산한다.")
    void calculateQuantity(int amount, int expected) {
        Money money = new Money(amount);
        int quantity = money.calculateQuantity(1000);
        assertThat(quantity).isEqualTo(expected);
    }
}
