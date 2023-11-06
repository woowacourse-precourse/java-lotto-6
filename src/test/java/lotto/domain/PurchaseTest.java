package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.constants.ErrorMessages;
import lotto.constants.GameInfo;
import lotto.validator.impl.MoneyValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseTest {
    private MoneyValidator moneyValidator = new MoneyValidator();

    @DisplayName("구입 금액이 1000원 미만일 경우 예외 발생")
    @Test
    void purchaseMoneyLessThan1000() {
        assertThatThrownBy(() -> new Purchase(String.valueOf(GameInfo.USER_MONEY_MIN.getNumber()-1), moneyValidator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_MONEY_RANGE.getMessage());
    }

    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외 발생")
    @Test
    void purchaseMoneyNotMultipleOf1000() {
        assertThatThrownBy(() -> new Purchase(String.valueOf(GameInfo.USER_MONEY_UNIT.getNumber()+1), moneyValidator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_MONEY_UNIT.getMessage());
    }

    @DisplayName("구입 금액이 숫자가 아닐 경우 예외 발생")
    @Test
    void purchaseMoneyNotNumeric() {
        assertThatThrownBy(() -> new Purchase("a", moneyValidator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_MONEY_NUMERIC.getMessage());
    }

    @DisplayName("금액에 맞춰 최대 개수의 로또를 구매")
    @Test
    void purchaseLotto() {
        // given
        String money = "10000";
        String lottoCount = "10";

        // when
        Purchase purchase = new Purchase("10000", moneyValidator);

        // then
        assertEquals(10, purchase.getLottoCount());
    }
}