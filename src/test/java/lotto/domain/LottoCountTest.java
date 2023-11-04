package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoCountTest {
    @DisplayName("로또 구매 금액을 통해 로또 개수를 얻는다")
    @Test
    void 구매금액에따른_로또개수_검증() {
        int price = 7000;
        int lottoPrice = 1000;
        LottoCount lottoCount = LottoCount.from(PurchaseAmount.from(price));
        assertThat(lottoCount.getLottoCount()).isEqualTo(price / lottoPrice);
    }

}