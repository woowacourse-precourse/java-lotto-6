package lotto.service;

import lotto.domain.Money;
import lotto.domain.NumbersGenerator;

public class LottoMarketService {
    private static final int LOTTO_PRICE = 1000;
    private final NumbersGenerator numbersGenerator;
    private final int purchasedCount;
    
    public LottoMarketService (Money money, NumbersGenerator numbersGenerator) {
        this.purchasedCount = convertMoneyIntoCount(money);
        this.numbersGenerator = numbersGenerator;
    }

    private int convertMoneyIntoCount(Money money) {
        return money.getValue() / LOTTO_PRICE;
    }

    public int getPurchasedCount() {
        return purchasedCount;
    }
}
