package lotto.domain;

import lotto.constant.Value;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSellerTest {

    @DisplayName("[기능]LottoSeller_로또판매__돈받은만큼_발행")
    @Test
    void sellLottoTest() {
        int money = 6000;

        LottoSeller seller = LottoSeller.create();
        LottoPaper lottoPaper = seller.sellLottos(money);

        int answerCount = money / Value.THOUSAND.get();
        Assertions.assertThat(lottoPaper.size()).isEqualTo(answerCount);
    }
}