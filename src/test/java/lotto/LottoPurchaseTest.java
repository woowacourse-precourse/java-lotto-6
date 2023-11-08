package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.dto.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {
    @DisplayName("로또 구매 금액이 로또 개별 금액 단위의 금액이 아니라면 예외가 발생한다.")
    @Test
    void buyLottoByNotLottoPriceAmount() {
        assertThatThrownBy(() -> LottoPurchase.from(LottoPurchase.LOTTO_PRICE - 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("한 번에 구매할 수 있는 최대 금액을 넘어가면 예외가 발생한다.")
    @Test
    void buyLottoByMoreThanLimitedAmount() {
        assertThatThrownBy(() -> LottoPurchase.from(LottoPurchase.MAX_PURCHASE_AMOUNT + 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
