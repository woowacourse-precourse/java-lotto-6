package lotto.model.service;

import lotto.configuration.LottoConstants;
import lotto.model.dto.LottoWallet;
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

        LottoWallet lottoWallet = lottoGenerator.purchaseLotto(purchaseMoney);

        Assertions.assertThat(lottoWallet.getLottos().size())
                .isEqualTo(purchaseMoney.getValue() / LottoConstants.LOTTO_PRICE);
    }
}