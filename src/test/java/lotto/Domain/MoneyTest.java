package lotto.Domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.Exception.CommonValidationException;
import lotto.Exception.MoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("범위 밖에 구매금액을 입력했을때 예외발생하는지 확인")
    @Test
    void createMoneyByOutOfRange() {
        String inputMoney1 = "999";
        String inputMoney2 = "100001";

        assertThrows(MoneyException.class, () -> Money.of(inputMoney1));
        assertThrows(MoneyException.class, () -> Money.of(inputMoney2));
    }

    @DisplayName("1000원 단위가 아닌 금액을 입력했을때 예외발생하는지 확인")
    @Test
    void createMoneyByNotDivisible() {
        String inputMoney = "1001";

        assertThrows(MoneyException.class, () -> Money.of(inputMoney));
    }


    @DisplayName("공백이 포함된 금액을 입력했을때 예외발생하는지 확인")
    @Test
    void createMoneyByHasBlank() {
        String inputMoney = "1 000";

        assertThrows(CommonValidationException.class, () -> Money.of(inputMoney));
    }
}