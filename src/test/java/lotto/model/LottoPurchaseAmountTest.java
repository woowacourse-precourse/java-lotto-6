package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoPurchaseAmountTest {
    @Test
    void createLottoPurchaseAmount() {
        String inputPurchaseAmount = "5000";
        LottoPurchaseAmount purchaseAmount = LottoPurchaseAmount.from(inputPurchaseAmount);

        assertThat(purchaseAmount).isInstanceOf(LottoPurchaseAmount.class);
    }
}