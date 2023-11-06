package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseServiceTest {
    @DisplayName("주어진 개수만큼 로또 발매")
    @Test
    void purchaseLotto() {
        // give
        LottoPurchaseService purchase = new LottoPurchaseService();
        int purchaseAmount = 10;
        // when
        HashSet<Lotto> purchasedLotto = purchase.purchase(purchaseAmount);
        // then
        assertThat(purchasedLotto.size()).isEqualTo(purchaseAmount);
    }
}