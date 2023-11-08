package lotto.domain;

import lotto.constant.Value;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

class LottoSellerTest {

    @DisplayName("[기능]LottoSeller_로또판매__돈받은만큼_발행")
    @Test
    void sellLottoTest() {
        BigDecimal money = new BigDecimal(6000);

        LottoSeller seller = LottoSeller.create();
        LottoPaper lottoPaper = seller.sellLottos(money);

        long answerCount = money.divide(new BigDecimal(Value.THOUSAND.get())).longValue();
        Assertions.assertThat(lottoPaper.size()).isEqualTo(answerCount);
    }
}