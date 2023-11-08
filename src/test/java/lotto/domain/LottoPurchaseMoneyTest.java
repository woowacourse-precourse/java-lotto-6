package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.constant.ErrorMessage.INCORRECT_MONEY_UNIT;
import static lotto.constant.ErrorMessage.NOT_ENOUGH_MONEY;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseMoneyTest {

    @DisplayName("로또 구매금이 1000원보다 작을 시 예외가 발생한다.")
    @Test
    void createLottoPurchaseMoneyByNotEnough() {
        assertThatThrownBy(() -> new LottoPurchaseMoney(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ENOUGH_MONEY);
    }

    @DisplayName("로또 구매금 1000원 단위가 아닐 시 예외가 발생한다.")
    @Test
    void createLottoPurchaseMoneyByIncorrectUnit() {
        assertThatThrownBy(() -> new LottoPurchaseMoney(1100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INCORRECT_MONEY_UNIT);
    }

    @DisplayName("로또 구매금에 따라 구매할 수 있는 로또 개수를 알 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,1","2000,2","4000,4"})
    void calculateNumberOfLottoAvailableForPurchase(int money, int expectedNumberOfLotto) {
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney(money);
        int numberOfLottoAvailableForPurchase = lottoPurchaseMoney.getNumberOfLottoAvailableForPurchase();
        Assertions.assertThat(numberOfLottoAvailableForPurchase).isEqualTo(expectedNumberOfLotto);
    }
}