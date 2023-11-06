package lotto.Domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.Exception.CommonValidationException;
import lotto.Exception.MoneyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("범위 밖에 구매금액을 입력했을때 예외발생하는지 확인")
    @Test
    void createMoneyByOutOfRange() {
        String inputMoney1 = "999";
        String inputMoney2 = "100001";

        assertThrows(MoneyException.class, () -> Money.from(inputMoney1));
        assertThrows(MoneyException.class, () -> Money.from(inputMoney2));
    }

    @DisplayName("범위 안에 구매 금액을 입력했을때 정상수행되는지 확인")
    @Test
    void createMoneyByInRange() {
        //given
        String inputMoney1 = "1000";
        String inputMoney2 = "100000";

        //when
        Money money1 = Money.from(inputMoney1);
        Money money2 = Money.from(inputMoney2);

        //then
        assertThat(money1.getMoney()).isEqualTo(1000);
        assertThat(money2.getMoney()).isEqualTo(100000);
    }

    @DisplayName("1000원 단위가 아닌 금액을 입력했을때 예외발생하는지 확인")
    @Test
    void createMoneyByNotDivisible() {
        String inputMoney = "1001";

        assertThrows(MoneyException.class, () -> Money.from(inputMoney));
    }


    @DisplayName("공백이 포함된 금액을 입력했을때 예외발생하는지 확인")
    @Test
    void createMoneyByHasBlank() {
        String inputMoney = "1 000";

        assertThrows(CommonValidationException.class, () -> Money.from(inputMoney));
    }

    @DisplayName("정수 이외의 값이 들어 왔을때 예외발생하는지 확인")
    @Test
    void createMoneyByNotInteger() {
        String inputMoney = "1.000";

        assertThrows(CommonValidationException.class, () -> Money.from(inputMoney));
    }

    @DisplayName("정상수행시나리오")
    @Test
    void createMoneyBySize() {
        //given
        String inputMoney = "1000";

        //when
        Money money = Money.from(inputMoney);

        //then
        assertThat(money).isNotNull();
    }

}