package lotto;

import lotto.model.LottoConfig;
import lotto.model.LottoModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoModelTest {
    @Test
    void setInputPriceTest() {
        LottoModel lottoModel = new LottoModel();
        int price = 10000;

        lottoModel.setInputPrice(price);

        assertEquals(price, lottoModel.getInputPrice());
    }

    @Test
    void calcPurchasedCountTest() {
        LottoModel lottoModel = new LottoModel();
        int price = 10000;
        lottoModel.setInputPrice(price);

        lottoModel.calcPurchasedCount();

        int expectedPurchasedCount = price / LottoConfig.LOTTO_PRICE;
        assertEquals(expectedPurchasedCount, lottoModel.getPurchasedCount());
    }

    @Test
    void getPurchasedLottoTest() {
        LottoModel lottoModel = new LottoModel();
        int count = 5;

        List<Lotto> purchasedLotto = lottoModel.getPurchasedLotto(count);

        assertEquals(count, purchasedLotto.size());
    }
}
