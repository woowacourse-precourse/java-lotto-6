package lotto.service;

import lotto.domain.Money;

public class LottoMarketService {
    private static final int LOTTO_PRICE = 1000;
    private final int purchasedCount;
    
    public LottoMarketService (Money money) {
        this.purchasedCount = convertMoneyIntoCount(money);
    }

    private int convertMoneyIntoCount(Money money) {
        return money.getValue() / LOTTO_PRICE;
    }

    public int getPurchasedCount() {
        return purchasedCount;
    }
}
