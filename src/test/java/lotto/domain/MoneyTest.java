package lotto.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @DisplayName("정상적으로 money를 생성한다.")
    @Test
    void createValidMoney() {
        // when
        ThrowingCallable actual = () -> new Money(1000);

        // then
        assertThatCode(actual).doesNotThrowAnyException();
    }

    @DisplayName("Money 더하기 테스트")
    @Test
    void moneyPlusTest() {
        // given
        Money money1 = new Money(1000);
        Money money2 = new Money(12500);

        // when
        Money result = money1.plus(money2);

        // then
        assertThat(result).isEqualTo(new Money(13500));
    }

    @DisplayName("음수의 숫자를 받을경우 예외가 발생한다.")
    @Test
    void createMoneyByMinusNumber() {
        // when
        ThrowingCallable actual = () -> new Money(-1);

        // then
        assertThatThrownBy(actual).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("특정 수로 나눌 수 있는지 확인한다.")
    @ParameterizedTest
    @MethodSource("divisibleMoneyInputProvider")
    public void divisibleMoney(long source, long divisor, boolean expected) {
        // given
        Money money = new Money(source);

        // when
        boolean actual = money.isDivisible(divisor);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("구매 가능한 Lotto 수를 확인한다.")
    @ParameterizedTest
    @MethodSource("quantityInputProvider")
    public void quantityAvailableForPurchase(long source, int expected) {
        // given
        Money money = new Money(source);

        // when
        int cnt = money.quantityAvailableForPurchase(1000);

        // then
        assertThat(cnt).isEqualTo(expected);
    }

    @DisplayName("나누어 떨어지지 않는 숫자를 입력할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {10003, 0, 12001, 999, 1})
    public void notAvailableForPurchase(long source) {
        // given
        Money money = new Money(source);

        // when
        ThrowingCallable actual = () -> money.quantityAvailableForPurchase(1000);

        // then
        assertThatThrownBy(actual).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> divisibleMoneyInputProvider() { // argument source method
        return Stream.of(
                Arguments.of("10000", 1000, true),
                Arguments.of("12000", 1000, true),
                Arguments.of("10003", 1000, false),
                Arguments.of("0", 1000, false),
                Arguments.of("12001", 1000, false),
                Arguments.of("999", 1000, false),
                Arguments.of("1", 1000, false)
        );
    }

    private static Stream<Arguments> quantityInputProvider() { // argument source method
        return Stream.of(
                Arguments.of("5000", 5),
                Arguments.of("10000", 10),
                Arguments.of("12000", 12)
        );
    }
}
