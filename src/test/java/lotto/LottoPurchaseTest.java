package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LottoPurchaseTest {

    @DisplayName("LottoPurchase 생성 테스트")
    @Test
    void testLottoPurchaseCreation() {
        String moneyInput = "5000";
        LottoPurchase lottoPurchase = new LottoPurchase(moneyInput);
        assertEquals(5000, lottoPurchase.getMoney());
    }

    @DisplayName("로또 구매 금액 계산 테스트")
    @Test
    void testLottoCountCalculation() {
        String moneyInput = "10000";
        LottoPurchase lottoPurchase = new LottoPurchase(moneyInput);
        int lottoCount = lottoPurchase.calculateLottoCount();
        assertEquals(10, lottoCount);
    }
}
