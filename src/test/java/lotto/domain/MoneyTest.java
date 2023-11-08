package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("Money는 서로 더할 수 있다.")
    @Test
    void plus() {
        //given
        Money money1 = new Money(1000);
        Money money2 = new Money(2000);

        //when
        Money plus = money1.plus(money2);

        //then
        assertThat(plus.compareTo(new Money(3000))).isEqualTo(0);
    }

    @DisplayName("Money는 서로 뺄 수 있다.")
    @Test
    void minus() {
        //given
        Money money1 = new Money(1000);
        Money money2 = new Money(2000);

        //when
        Money plus = money1.minus(money2);

        //then
        assertThat(plus.compareTo(new Money(-1000))).isEqualTo(0);
    }

    @DisplayName("Money는 서로 곱할 수 있다.")
    @Test
    void multiply() {
        //given
        Money money1 = new Money(1000);
        Money money2 = new Money(2000);

        //when
        Money plus = money1.multiply(money2);

        //then
        assertThat(plus.compareTo(new Money(1000*2000))).isEqualTo(0);
    }

    @DisplayName("Money에 돈이 있는지 알 수 있다.")
    @Test
    void hasMoney() {
        //given
        Money money = new Money(1000);

        //when
        boolean hasNotMoney = money.hasNotMoney();

        //then
        assertThat(hasNotMoney).isFalse();
    }

    @DisplayName("Money에 돈이 없는지 알 수 있다.")
    @Test
    void hasNotMoney() {
        //given
        Money money = new Money(0);

        //when
        boolean hasNotMoney = money.hasNotMoney();

        //then
        assertThat(hasNotMoney).isTrue();
    }

    @DisplayName("수익률을 계산할 수 있다.")
    @Test
    void rateOfReturn() {
        //given
        Money money = new Money(8000);
        Money finalMoney = new Money(13000);

        //when
        double rateOfReturn = money.calculateRateOfReturn(finalMoney);

        //then
        assertThat(rateOfReturn).isEqualTo(62.5);
    }

    @DisplayName("Money에 있는 돈을 1000단위로 ,를 찍어줄 수 있다.")
    @Test
    void formatWithCommas() {
        //given
        Money money = new Money(8000);

        //when
        String result = money.formatWithCommas();

        //then
        assertThat(result).isEqualTo("8,000");
    }
}