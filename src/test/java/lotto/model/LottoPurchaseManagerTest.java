package lotto.model;

import lotto.system.util.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoPurchaseManagerTest {
    @DisplayName("구입 금액에 따른 구입 수량 계산 확인")
    @ParameterizedTest(name = "구입 금액이 {0}원이면 {1}개 구입")
    @CsvSource(value = {"1000:1", "14000:14", "450000:450", "9990000:9990"}, delimiter = ':')
    public void 구입_수량_계산(int purchaseAmount, int expectedPurchaseQuantity) {
        // given
        LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(new LottoNumberGenerator());

        // when
        int calculatePurchaseQuantity = lottoPurchaseManager.calculatePurchaseQuantity(purchaseAmount);

        // then
        assertEquals(expectedPurchaseQuantity, calculatePurchaseQuantity);
    }
}