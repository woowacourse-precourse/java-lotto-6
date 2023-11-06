package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseManagerTest {
    @DisplayName("LottoPurchaseManager 생성 테스트")
    @Test
    void create() {
        //given
        String purchaseAmountInput = "10000";
        LottoPurchaseAmount lottoPurchaseAmount = LottoPurchaseAmount.create(purchaseAmountInput);
        LottoPurchaseManager lottoPurchaseManager = LottoPurchaseManager.create(lottoPurchaseAmount);

        //when, then
        assertThat(lottoPurchaseManager.getLottos().getLottos()).isNotNull();
        assertThat(lottoPurchaseManager.getPurchaseAmount().getAmount()).isEqualTo(lottoPurchaseAmount.getAmount());
    }
}
