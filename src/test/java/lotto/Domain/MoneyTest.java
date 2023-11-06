package lotto.Domain;

import static lotto.CommonValidation.CommonValidation.isValidLottoNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.Exception.CommonValidationException;
import lotto.Exception.MoneyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("올바른 범위에 속한 값이 아닐때 예외 발생하는 지 확인")
    @Test
    void createMoneyByOutOfRange() {
        String inputMoney1 = "999";
        String inputMoney2 = "100001";

        assertThrows(MoneyException.class, () -> Money.from(inputMoney1));
        assertThrows(MoneyException.class, () -> Money.from(inputMoney2));
    }

    @DisplayName("올바른 범위에 속한 값일때 정상 수행되는지 확인")
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

    @DisplayName("1000원 단위로 금액이 입력되었을때 정상 수행되는지 확인")
    @Test
    void createMoneyByDivisible() {
        //given
        String inputMoney = "1000";

        //when
        Money money = Money.from(inputMoney);

        //then
        assertThat(money.getMoney()).isEqualTo(1000);
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