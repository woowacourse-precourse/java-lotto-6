package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 상점 테스트")
class LottoStoreServiceTest {
    private LottoStoreService lottoStoreService;

    @BeforeEach
    void setUp() {
        lottoStoreService = new LottoStoreService(new LottoFactoryService());
    }

    @DisplayName("구입 금액에 맞는 개수의 로또를 받을 수 있다")
    @Test
    void testObtainedCountOfLotto() {
        PurchaseAmount purchaseAmount = PurchaseAmount.from(5000);
        List<Lotto> lottos = lottoStoreService.purchaseLotto(purchaseAmount);
        assertThat(lottos.size()).isEqualTo(5);
    }
}