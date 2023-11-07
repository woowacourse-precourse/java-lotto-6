package lotto.model.dto;

import lotto.model.LottoPaper;
import lotto.model.LottoPurchaseManager;
import lotto.system.util.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseResultTest {

    @DisplayName("로또 구입 결과를 저장한다.")
    @Test
    public void 로또_구입_프로세스_결과() {
        // given
        int purchaseAmount = 1000;
        LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(new LottoNumberGenerator());

        int purchaseQuantity = lottoPurchaseManager.calculatePurchaseQuantity(purchaseAmount);
        List<LottoPaper> purchasedLottoPapers = lottoPurchaseManager.purchaseLottoPapers(purchaseQuantity);

        // when
        PurchaseResult purchaseResult = new PurchaseResult(purchaseAmount, purchasedLottoPapers);

        // then
        assertEquals(purchaseAmount, purchaseResult.getPurchaseAmount());
        assertEquals(purchasedLottoPapers, purchaseResult.getPurchasedLottoPapers());
    }
}