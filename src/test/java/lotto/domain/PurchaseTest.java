package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.constants.ErrorMessages;
import lotto.constants.GameInfo;
import lotto.validator.impl.MoneyValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PurchaseTest {


    @DisplayName("구입 금액이 1000원 미만일 경우 예외 발생")
    @Test
    void purchaseMoneyLessThan1000() {
        // given
        MoneyValidator moneyValidator = Mockito.mock(MoneyValidator.class);
        String lessThanStandard = String.valueOf(GameInfo.USER_MONEY_MIN.getNumber() - 1);

        // when
        Mockito.doThrow(
            new IllegalArgumentException(ErrorMessages.INPUT_MONEY_RANGE.getMessage()))
            .when(moneyValidator).validate(lessThanStandard);

        // then
        assertThatThrownBy(() -> new Purchase(lessThanStandard, moneyValidator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_MONEY_RANGE.getMessage());
    }

    @DisplayName("구입 금액이 1000원 단위가 아닐 경우 예외 발생")
    @Test
    void purchaseMoneyNotMultipleOf1000() {
        // given
        MoneyValidator moneyValidator = Mockito.mock(MoneyValidator.class);
        String lessThanStandard = String.valueOf(GameInfo.USER_MONEY_MIN.getNumber() + 1);

        // when
        Mockito.doThrow(
                new IllegalArgumentException(ErrorMessages.INPUT_MONEY_UNIT.getMessage()))
            .when(moneyValidator).validate(lessThanStandard);

        // then
        assertThatThrownBy(() -> new Purchase(lessThanStandard, moneyValidator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_MONEY_UNIT.getMessage());
    }

    @DisplayName("구입 금액이 숫자가 아닐 경우 예외 발생")
    @Test
    void purchaseMoneyNotNumeric() {
        // given
        MoneyValidator moneyValidator = Mockito.mock(MoneyValidator.class);
        String lessThanStandard = "a";

        // when
        Mockito.doThrow(
                new IllegalArgumentException(ErrorMessages.INPUT_MONEY_NUMERIC.getMessage()))
            .when(moneyValidator).validate(lessThanStandard);

        // then
        assertThatThrownBy(() -> new Purchase(lessThanStandard, moneyValidator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_MONEY_NUMERIC.getMessage());
    }

    @DisplayName("금액에 맞춰 최대 개수의 로또를 구매")
    @Test
    void purchaseLotto() {
        // given
        int lottoCount = 10;
        String money = String.valueOf(GameInfo.USER_MONEY_UNIT.getNumber() * lottoCount);
        MoneyValidator moneyValidator = Mockito.mock(MoneyValidator.class);

        // when
        Mockito.doNothing().when(moneyValidator).validate(money);
        Purchase purchase = new Purchase(money, moneyValidator);

        // then
        assertEquals(lottoCount, purchase.getLottoCount());
    }
}