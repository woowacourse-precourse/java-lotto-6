package lotto.model.service;

import java.util.List;
import lotto.configuration.LottoConstants;
import lotto.model.domain.Lotto;
import lotto.model.dto.PurchaseMoney;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또 구매 수량 확인")
    public void lottoPurchaseTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(8000);
        LottoGenerator lottoGenerator = new LottoGenerator();

        List<Lotto> lottos = lottoGenerator.purchaseLotto(purchaseMoney);

        Assertions.assertThat(lottos.size())
                .isEqualTo(purchaseMoney.getValue() / LottoConstants.LOTTO_PRICE);
    }
}