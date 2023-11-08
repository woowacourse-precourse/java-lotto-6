package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {

    @Test
    @DisplayName("LottoPurchase 객체 생성 검증 테스트")
    void testLottoPurchaseCreation() {
        int count = 7;
        LottoPurchase lottoPurchase = LottoPurchase.create(count);

        int purchaseCount = lottoPurchase.getPurchaseCount().getCount();

        assertThat(purchaseCount).isEqualTo(7);
    }

    @Test
    @DisplayName("isRunning 기능이 정상 동작 하는지 검증")
    void testIsRunning() {
        int count = 7;
        LottoPurchase lottoPurchase = LottoPurchase.create(count);

        assertAll(
                () -> assertThat(lottoPurchase.isRunning(5)).isEqualTo(true),
                () -> assertThat(lottoPurchase.isRunning(7)).isEqualTo(false)
        );
    }
}