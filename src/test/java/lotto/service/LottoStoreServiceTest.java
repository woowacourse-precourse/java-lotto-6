package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 상점 테스트")
class LottoStoreServiceTest {

    @DisplayName("구입 금액에 맞는 개수의 로또를 받을 수 있다")
    @Test
    void testObtainedCountOfLotto() {
        PurchaseAmount purchaseAmount = PurchaseAmount.from(5000);
        LottoStoreService lottoStoreService = new LottoStoreService(new LottoFactoryService());
        List<Lotto> lottos = lottoStoreService.purchaseLotto(purchaseAmount);
        Assertions.assertThat(lottos.size()).isEqualTo(5);
    }
}