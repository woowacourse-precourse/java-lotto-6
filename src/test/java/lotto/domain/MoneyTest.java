package lotto.domain;

import static lotto.exception.ErrorMessage.INVALID_UNIT;
import static lotto.exception.ErrorMessage.NOT_ENOUGH_MONEY;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("투입한 금액이 1000원 단위로 돈이 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 1000000})
    void of(int input) {
        // given // when
        Money money = Money.from(input);

        // then
        Assertions.assertThat(money.calculateLottoCount()).isEqualTo(input / 1000);
    }

    @DisplayName("투입한 금액이 1000원 이상이어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 300, 500, 999})
    void ofNotEnoughMoney(int input) {
        assertThatThrownBy(() -> Money.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ENOUGH_MONEY.getMessage());
    }

    @DisplayName("투입한 금액이 1000원 단위이어야 한다.")
    @Test
    void ofByNotUnit() {
        // given
        int money = 5100;

        // when then
        assertThatThrownBy(() -> Money.from(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_UNIT.getMessage());
    }
}