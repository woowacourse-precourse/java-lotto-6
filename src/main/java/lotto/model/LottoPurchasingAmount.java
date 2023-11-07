package lotto.model;

import static java.lang.Integer.parseInt;

public class LottoPurchasingAmount {
    private static final int LOTTO_MINIMUM_PRICE = 1000;
    private final int lottoAmount;

    public LottoPurchasingAmount(String moneyFromUserInput) {
        this.lottoAmount = parseInt(moneyFromUserInput) / LOTTO_MINIMUM_PRICE;
    }
}
