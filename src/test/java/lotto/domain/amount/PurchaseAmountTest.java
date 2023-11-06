package lotto.domain.amount;

import static lotto.util.ConstantUtils.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    private final int INITIAL_PURCHASE_AMOUNT = 3000;

    private PurchaseAmount purchaseAmount;

    @BeforeEach
    void setup() {
        purchaseAmount = PurchaseAmount.from(INITIAL_PURCHASE_AMOUNT);
    }

    @DisplayName("금액이 1000원으로 나누어 떨어지지 않는다면 예외를 발생한다.")
    @Test
    void createAmountByNumber() {
        assertThatThrownBy(() -> PurchaseAmount.from(1001))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원 미만이라면 예외를 발생한다.")
    @Test
    void createAmountLessThanThousand() {
        assertThatThrownBy(() -> PurchaseAmount.from(0))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 시 구입 금액에서 1000원을 차감한다.")
    @Test
    void purchaseLottoDecreasesAmount() {
        purchaseAmount = purchaseAmount.subtractLottoCost();
        assertThat(purchaseAmount.getAmount()).isEqualTo(INITIAL_PURCHASE_AMOUNT - LOTTO_COST_CRITERION);
    }
}