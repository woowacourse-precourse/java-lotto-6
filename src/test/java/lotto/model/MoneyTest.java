package lotto.model;

import static lotto.view.ErrorMessage.LESS_MONEY;
import static lotto.view.ErrorMessage.NOT_DIVISIBLE_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @DisplayName("구입금액이 최소 구입가격보다 적으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {1, 2, 999, 200, 400, 500})
    void 예외테스트_createMoneyLessThanMinValue(long input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LESS_MONEY.getMessage());
        ;
    }

    @DisplayName("구입금액이 로또 가격 단위로 나뉘지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {1034, 512312023, 5203, 60090, 9223372036854775807L})
    void 예외테스트_createMoneyNotDivisibleByLottoPrice(long input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DIVISIBLE_MONEY.getMessage());
        ;
    }

    @DisplayName("정상 테스트")
    @ParameterizedTest
    @ValueSource(longs = {1000, 2000, 2000000000, 2012320000, 1231241231000L, 9223372036854775000L})
    void 정상테스트_createMoney(long input) {
        //given
        long expect = input;
        //when
        Money money = new Money(input);
        long result = money.getAmount();
        //then
        assertThat(result).isEqualTo(expect);
    }
}
