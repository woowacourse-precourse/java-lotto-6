package lotto;

import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.LessThanLottoPriceException;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int num;

    public Money(int num) {
        if (num < LOTTO_PRICE) {
            throw new LessThanLottoPriceException();
        }

        if (num % 1000 != 0) {
            throw new InvalidPurchaseAmountException();
        }
        this.num = num;
    }

    public int purchase() {
        return num / LOTTO_PRICE;
    }

    public int purchaseMoney() {
        int purchase = purchase();
        return purchase * LOTTO_PRICE;
    }
}
