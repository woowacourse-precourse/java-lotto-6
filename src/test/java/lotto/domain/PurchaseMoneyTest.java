package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.enums.ExceptionMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseMoneyTest {

    @Test
    @DisplayName("올바른 금액을 입력한 경우")
    void 올바른_금액_입력() throws Exception{
        //given
        final String inputMoney = "3000";

        //when
        PurchaseMoney purchaseMoney = new PurchaseMoney(inputMoney);

        // then
        assertThat(purchaseMoney.getValue()).isEqualTo(3000);
    }

    @Test
    @DisplayName("공백과 함께 올바른 금액을 입력한 경우")
    void 공백이랑_올바른_금액_입력() throws Exception{
        //given
        final String inputMoney = " 3000";

        //when,then
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .hasMessage(ExceptionMessages.PURCHASE_MONEY_IS_NOT_NUMBER.getMessage());
    }

    @Test
    @DisplayName("1000보다 크고, 1,000 단위가 아닌 돈을 입력한 경우")
    void 천단위_아닌_돈_입력() throws Exception{
        //given
        final String inputMoney = "1200";

        //when,then
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .hasMessage(ExceptionMessages.PURCHASE_MONEY_IS_NOT_DIVIDENED_BY_ONE_THOUSAND.getMessage());

    }

    @Test
    @DisplayName("빈 값을 입력한 경우")
    void 빈_값_입력() throws Exception{
        //given
        final String inputMoney = "";

        //when,then
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .hasMessage(ExceptionMessages.PURCHASE_MONEY_IS_EMPTY_VALUE.getMessage());
    }

    @Test
    @DisplayName("빈 값을 입력한 경우")
    void 널_값_입력() throws Exception{

        //given
        final String inputMoney = null;

        //when,then
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .hasMessage(ExceptionMessages.PURCHASE_MONEY_IS_EMPTY_VALUE.getMessage());
    }

    @Test
    @DisplayName("빈 값을 입력한 경우")
    void 공백_입력() throws Exception{

        //given
        final String inputMoney = " ";

        //when,then
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .hasMessage(ExceptionMessages.PURCHASE_MONEY_IS_EMPTY_VALUE.getMessage());
    }

    @Test
    @DisplayName("문자를 입력한 경우")
    void 문자_입력() throws Exception{

        //given
        final String inputMoney = "abc";

        //when,then
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .hasMessage(ExceptionMessages.PURCHASE_MONEY_IS_NOT_NUMBER.getMessage());
    }

    @Test
    @DisplayName("1000보다 작은 수를 입력한 경우")
    void 천보다_작은수_입력() throws Exception{

        //given
        final String inputMoney = "300";

        //when,then
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .hasMessage(ExceptionMessages.PURCHASE_MONEY_IS_NOT_OVER_ONE_THOUSAND.getMessage());
    }

    @Test
    @DisplayName("음수를 입력한 경우")
    void 음수_입력() throws Exception{
        //given
        final String inputMoney = "-1";

        //when,then
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseMoney(inputMoney))
                .hasMessage(ExceptionMessages.PURCHASE_MONEY_IS_NOT_OVER_ONE_THOUSAND.getMessage());
    }
}
