package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}