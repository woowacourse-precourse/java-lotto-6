package lotto.domain;

import lotto.service.LottoPurchaseManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseManagerTest {
    @DisplayName("LottoPurchaseManager 생성 테스트")
    @Test
    void create() {
        //given
        int purchaseAmountInput = 10000;
        LottoPurchaseAmount lottoPurchaseAmount = LottoPurchaseAmount.from(purchaseAmountInput);
        LottoPurchaseManager lottoPurchaseManager = LottoPurchaseManager.from(lottoPurchaseAmount);

        //when, then
        assertThat(lottoPurchaseManager.getLottos().getLottos()).isNotNull();
        assertThat(lottoPurchaseManager.getPurchaseAmount().getAmount()).isEqualTo(lottoPurchaseAmount.getAmount());
    }
}
