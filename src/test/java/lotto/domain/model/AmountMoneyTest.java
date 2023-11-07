package lotto.domain.model;

import static lotto.exception.lottoamountexception.AmountErrorMessage.BELOW_MINIMUM_AMOUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.exception.lottoamountexception.LottoAmountInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountMoneyTest {

    @DisplayName("로또 구매 금액을 정상적으로 입력한다.")
    @ParameterizedTest(name = "로또 구매 금액: {0}")
    @ValueSource(ints = {1000, 2000, 10000, 19000})
    void createAmountMoney(int money){
        // when
        AmountMoney amountMoney = new AmountMoney(money);

        // then
        assertEquals(money, amountMoney.getAmount());
    }

    @DisplayName("로또 구매 금액을 1000원 미만으로 입력하는 경우 예외 발생")
    @ParameterizedTest(name = "로또 구매 금액: {0}")
    @ValueSource(ints = {-1000, 0, 500, 999})
    void createAmountMoneyUnder1000(int money){
        // when & then
        assertThatThrownBy(() -> new AmountMoney(money))
                .isInstanceOf(LottoAmountInputException.class)
                .hasMessage(BELOW_MINIMUM_AMOUNT.getMessage());
    }
}