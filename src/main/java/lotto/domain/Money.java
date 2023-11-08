package lotto.domain;

import lotto.config.LottoGameRule;
import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.LessThanLottoPriceException;

public class Money {
    private final int amount;

    public Money(final int amount) {
        validateMinAmount(amount);
        validateAmountUnit(amount);
        this.amount = amount;
    }

    private void validateAmountUnit(int number) {
        if (number % LottoGameRule.PURCHASE_AMOUNT_UNIT.value() != 0) {
            throw new InvalidPurchaseAmountException();
        }
    }

    private void validateMinAmount(int number) {
        if (number < LottoGameRule.LOTTO_PRICE.value()) {
            throw new LessThanLottoPriceException();
        }
    }

    public int purchase() {
        return amount / LottoGameRule.LOTTO_PRICE.value();
    }

    public int purchasedMoney() {
        int purchase = purchase();
        return purchase * LottoGameRule.LOTTO_PRICE.value();
    }
}
