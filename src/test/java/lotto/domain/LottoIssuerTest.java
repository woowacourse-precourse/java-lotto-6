package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssuerTest {

    @DisplayName("구입 금액만큼 로또를 발행했을 때, 로또 개수는 (구매 금액/로또 가격)과 같다.")
    @Test
    void issue_Success_LottosSizeIsSameAsPurchaseAmountPerLottoPrice() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(4000);
        LottoIssuer lottoIssuer = new LottoIssuer();

        // when
        List<Lotto> lottos = lottoIssuer.issue(purchaseAmount);

        // then
        Assertions.assertThat(lottos.size()).isEqualTo(4);
    }
}
