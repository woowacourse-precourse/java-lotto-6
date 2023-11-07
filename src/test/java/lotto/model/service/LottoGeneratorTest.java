package lotto.model.service;

import lotto.configuration.LottoConstants;
import lotto.model.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또 구매 수량 확인")
    public void lottoPurchaseTest() {
        int money = 10000;
        LottoGenerator lottoGenerator = new LottoGenerator();

        List<Lotto> lottos = lottoGenerator.purchaseLotto(money);

        Assertions.assertThat(lottos.size())
                .isEqualTo(money / LottoConstants.LOTTO_PRICE);
    }
}