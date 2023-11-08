package lotto.Domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.Exception.MoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    private final String invalidInputMoney1 = "999";
    private final String invalidInputMoney2 = "100001";
    private final String invalidInputMoney3 = "1001";
    private final String validInputMoney1 = "1000";
    private final String validInputMoney2 = "100000";
    private final int validMoney1 = 1000;
    private final int validMoney2 = 100000;

    @DisplayName("올바른 범위에 속한 값이 아닐때 예외 발생하는 지 확인")
    @Test
    void createMoneyByOutOfRange() {
        assertThrows(MoneyException.class, () -> Money.from(invalidInputMoney1));
        assertThrows(MoneyException.class, () -> Money.from(invalidInputMoney2));
    }

    @DisplayName("올바른 범위에 속한 값일때 정상 수행되는지 확인")
    @Test
    void createMoneyByInRange() {
        //given

        //when
        Money money1 = Money.from(validInputMoney1);
        Money money2 = Money.from(validInputMoney2);

        //then
        assertThat(money1.getValue()).isEqualTo(validMoney1);
        assertThat(money2.getValue()).isEqualTo(validMoney2);
    }

    @DisplayName("1000원 단위가 아닌 금액을 입력했을때 예외발생하는지 확인")
    @Test
    void createMoneyByNotDivisible() {
        assertThrows(MoneyException.class, () -> Money.from(invalidInputMoney3));
    }

    @DisplayName("1000원 단위로 금액이 입력되었을때 정상 수행되는지 확인")
    @Test
    void createMoneyByDivisible() {
        //given
        //when
        Money money = Money.from(validInputMoney1);

        //then
        assertThat(money.getValue()).isEqualTo(validMoney1);
    }


    @DisplayName("정상수행시나리오")
    @Test
    void createMoneyBySize() {
        //given
        //when
        Money money = Money.from(validInputMoney1);

        //then
        assertThat(money).isNotNull();
    }

}