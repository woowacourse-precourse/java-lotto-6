package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoPurchaseServiceTest {

    private final LottoPurchaseService service = new LottoPurchaseService();

    @Test
    @DisplayName("로또 티켓 개수 테스트")
    void purchaseLottoWithValidAmount() {
        int purchaseAmount = 3000; // Should result in 3 Lotto tickets
        List<Lotto> lotto = service.purchaseLotto(purchaseAmount);
        assertThat(lotto).hasSize(3);
    }

    @Test
    @DisplayName("Purchase amount not divisible by Lotto price should throw IllegalArgumentException")
    void purchaseLottoWithInvalidAmount() {
        int purchaseAmount = 1550; // Not divisible by 1000
        assertThatThrownBy(() -> service.purchaseLotto(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

}