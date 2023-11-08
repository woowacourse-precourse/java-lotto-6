package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseServiceTest {

    @Test
    @DisplayName("입력한 구입금액을 구매개수로 바꾼후 LottoPurchase에 잘 저장되는지 테스트")
    void testCreateLottoPurchase() {
        String purchaseAmount = "8000";
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();

        LottoPurchase lottoPurchase = lottoPurchaseService.createLottoPurchase(purchaseAmount);
        int purchaseCount = lottoPurchase.getPurchaseCount().getCount();

        assertThat(purchaseCount).isEqualTo(8);
    }
}