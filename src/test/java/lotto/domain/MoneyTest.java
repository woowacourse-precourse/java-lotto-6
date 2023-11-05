package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.error.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("금액으로 음수를 입력하면 예외가 발생한다.")
    @Test
    void createMoneyWithNegativeNumber() {
        // given & when & then
        assertThatThrownBy(() -> new Money(-1L))
                .isInstanceOf(LottoException.class);
    }

    @DisplayName("금액의 합을 계산한다.")
    @Test
    void add() {
        // given
        final Long amount1 = 5000L;
        final Long amount2 = 15000L;
        final Money money1 = new Money(amount1);
        final Money money2 = new Money(amount2);
        final Money expected = new Money(amount1 + amount2);

        // when
        final Money actual = money1.add(money2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("금액의 곱을 계산한다.")
    @Test
    void multiply() {
        // given
        final long amount = 5000L;
        final long multiplier = 5L;
        final Money money = new Money(amount);
        final Money expected = new Money(amount * multiplier);

        // when
        final Money actual = money.multiply(multiplier);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("금액의 나누기를 계산한다.")
    @Test
    void divide() {
        // given
        final Long amount = 5000L;
        final Long dividerAmount = 5L;
        final Money money = new Money(amount);
        final Money divider = new Money(dividerAmount);
        final Long expected = amount / dividerAmount;

        // when
        final Long actual = money.divide(divider);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("금액을 비교한다.")
    @Test
    void isGreaterThan() {
        // given
        final Money money1 = new Money(5000L);
        final Money money2 = new Money(15000L);

        // when
        final boolean actual = money1.isGreaterThan(money2);

        // then
        assertThat(actual).isFalse();
    }

    @DisplayName("1,000원 단위인지 확인한다.")
    @Test
    void isThousandUnit() {
        // given
        final Money money1 = new Money(5000L);
        final Money money2 = new Money(5001L);

        // when
        final boolean actual1 = money1.isThousandUnit();
        final boolean actual2 = money2.isThousandUnit();

        // then
        assertAll(() -> {
            assertThat(actual1).isTrue();
            assertThat(actual2).isFalse();
        });
    }

    @DisplayName("금액의 비율을 계산한다.")
    @Test
    void getRate() {
        // given
        final Long amount1 = 5000L;
        final Long amount2 = 15000L;
        final Money money1 = new Money(amount1);
        final Money money2 = new Money(amount2);
        final float expected = (float) amount2 / amount1;

        // when
        final float actual = money1.getRate(money2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("동일한 금액인지 확인한다.")
    @Test
    void equals() {
        // given
        final Long amount = 5000L;
        final Long notSameAmount = 15000L;
        final Money money1 = new Money(amount);
        final Money money2 = new Money(amount);
        final Money money3 = new Money(notSameAmount);

        // when
        final boolean actual = money1.equals(money2);
        final boolean falseActual = money1.equals(money3);

        // then
        assertAll(() -> {
            assertThat(actual).isTrue();
            assertThat(falseActual).isFalse();
        });
    }
}
