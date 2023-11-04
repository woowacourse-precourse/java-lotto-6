package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.Messages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasedLottosTest {

    @DisplayName("구매금액이 최소값 미만 일 경우 예외가 발생한다.")
    @Test
    void createPurchasedLottosWhenAmountIsLessThanMinimum() {
        assertThatThrownBy(() -> new PurchasedLottos(800))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_AMOUNT_LESS_THAN_UNIT);
    }

    @DisplayName("구매금액이 최대값을 초과할 경우 예외가 발생한다.")
    @Test
    void createPurchasedLottosWhenAmountExceedsMaximum() {
        assertThatThrownBy(() -> new PurchasedLottos(100001000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_AMOUNT_MAX_RANGE);
    }

    @DisplayName("구매금액이 1000원단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createPurchasedLottosBy() {
        assertThatThrownBy(() -> new PurchasedLottos(12300))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_AMOUNT_NOT_MULTIPLE_OF_UNIT);
    }

}
