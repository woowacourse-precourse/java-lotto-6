package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoPurchaseManagerTest {

    @Test
    void createLottoPurchaseManager() {
        // 유효한 금액으로 테스트
        assertDoesNotThrow(() -> LottoPurchaseManager.createLottoPurchaseManager("10000"));

        // 음수 금액으로 테스트
        assertThrows(IllegalStateException.class, () -> LottoPurchaseManager.createLottoPurchaseManager("-100"));

        // 0원으로 테스트
        assertThrows(IllegalStateException.class, () -> LottoPurchaseManager.createLottoPurchaseManager("0"));

        // 로또 최대 개수를 초과하는 금액으로 테스트
        assertThrows(IllegalArgumentException.class, () -> LottoPurchaseManager.createLottoPurchaseManager("10001"));

        // 1000원 단위가 아닌 금액으로 테스트
        assertThrows(IllegalArgumentException.class, () -> LottoPurchaseManager.createLottoPurchaseManager("5500"));

        // 숫자가 아닌 문자열로 테스트
        assertThrows(IllegalStateException.class, () -> LottoPurchaseManager.createLottoPurchaseManager("abc"));
    }
}
