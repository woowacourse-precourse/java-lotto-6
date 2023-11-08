package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseCountTest {

    @DisplayName("유효한 구매 금액으로 PurchaseCount 생성")
    @Test
    void createPurchaseCountWithValidPurchaseAmount() {
        int purchaseAmount = 3000;
        PurchaseCount purchaseCount = new PurchaseCount(purchaseAmount);

        assertThat(purchaseCount.getValue()).isEqualTo(purchaseAmount / 1000);
    }

    @DisplayName("유효하지 않은 구매 금액으로 PurchaseCount 생성 시 예외 발생")
    @Test
    void createPurchaseCountWithInvalidPurchaseAmount() {
        int purchaseAmount = 2500;

        assertThatThrownBy(() -> new PurchaseCount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
    }

}