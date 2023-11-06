package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseManagerTest {
    @DisplayName("LottoPurchaseManager 생성 테스트")
    @Test
    void create() {
        //given
        String purchaseAmountInput = "10000";
        LottoPurchaseAmount lottoPurchaseAmount = LottoPurchaseAmount.create(purchaseAmountInput);
        LottoPurchaseManager lottoPurchaseManager = LottoPurchaseManager.create(lottoPurchaseAmount);

        //when, then
        Assertions.assertThat(lottoPurchaseManager.getLottos().getLottos()).isNotNull();
    }
}
