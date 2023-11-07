package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    private static final int LOTTO_PRICE = 1000;

    @DisplayName("구매금액이 음수일 때 예외처리한다")
    @Test
    void throwExceptionWhenPurchaseAmountIsNegative() {
        assertThatThrownBy(() -> {
            PurchaseAmount purchaseAmount = new PurchaseAmount("-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위의 구매금액이 아닐 때 예외처리한다")
    @Test
    void throwExceptionWhenPurchaseAmountCanNotDivideByThousand() {
        assertThatThrownBy(() -> {
            PurchaseAmount purchaseAmount = new PurchaseAmount("1001");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("아직 구매금액만큼 로또가 발행되지 않았을 때 true를 반환한다")
    @Test
    void shouldReturnFalseWhenLottosAreNotFullyIssued() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("10000");
        int issuedCount = 5;
        assertTrue(purchaseAmount.isNotFullyIssued(issuedCount));
    }

}
