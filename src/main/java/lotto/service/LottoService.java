package lotto.service;

import java.util.List;
import lotto.domain.LottoWallet;
import lotto.domain.PurchaseMoney;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumbers;

public class LottoService {
    final static int LOTTO_PRICE = 1000;

    public LottoWallet purchase(Integer purchaseAmount) {
        new PurchaseMoney(purchaseAmount);
        int lottoCount = getLottoCount(purchaseAmount);
        return new LottoWallet(lottoCount);
    }

    private int getLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
