package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoShopTest {

    @DisplayName("로또를 구매할 수 있다.")
    @Test
    void purchaseByAmount() {
        List<Lotto> lottos = new LottoShop().purchase(new PurchaseAmount(10000L));

        assertThat(lottos).size().isEqualTo(10);
    }
}
