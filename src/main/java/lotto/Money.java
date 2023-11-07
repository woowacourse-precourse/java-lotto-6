package lotto;

import lotto.config.LottoGameRule;
import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.LessThanLottoPriceException;

public class Money {
    private final int num;

    public Money(final int num) {
        if (num < LottoGameRule.LOTTO_PRICE.value()) {
            throw new LessThanLottoPriceException();
        }

        if (num % LottoGameRule.PURCHASE_AMOUNT_UNIT.value() != 0) {
            throw new InvalidPurchaseAmountException();
        }
        this.num = num;
    }

    public int purchase() {
        return num / LottoGameRule.LOTTO_PRICE.value();
    }

    public int purchaseMoney() {
        int purchase = purchase();
        return purchase * LottoGameRule.LOTTO_PRICE.value();
    }
}
