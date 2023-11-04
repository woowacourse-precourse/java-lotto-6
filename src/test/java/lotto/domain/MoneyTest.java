package lotto.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
}
