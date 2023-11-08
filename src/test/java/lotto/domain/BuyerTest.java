package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BuyerTest {

    @Test
    void purchaseLottoTest() {
        // given
        int purchaseAmount1 = 1000;
        int purchaseAmount2 = 1000;
        int purchaseAmount3 = 1000;
        int lottoPrice = 1000;

        Buyer buyer1 = new Buyer(purchaseAmount1);
        Buyer buyer2 = new Buyer(purchaseAmount2);
        Buyer buyer3 = new Buyer(purchaseAmount3);

        // when & then
        assertThat(purchaseAmount1/lottoPrice).isEqualTo(buyer1.getLottoList().size());
        assertThat(purchaseAmount2/lottoPrice).isEqualTo(buyer2.getLottoList().size());
        assertThat(purchaseAmount3/lottoPrice).isEqualTo(buyer3.getLottoList().size());
    }
}