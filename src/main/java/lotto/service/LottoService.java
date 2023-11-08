package lotto.service;

import lotto.domain.LottoWallet;
import lotto.domain.PurchaseMoney;

public class LottoService {
    final static int LOTTO_PRICE = 1000;

    public LottoWallet purchase(Integer purchaseAmount) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(purchaseAmount);
        int lottoCount = getLottoCount(purchaseAmount);
        return new LottoWallet(lottoCount);
    }

    private int getLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
