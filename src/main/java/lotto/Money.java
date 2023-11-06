package lotto;

import lotto.exception.LessThanLottoPriceException;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int num;

    public Money(int num) {
        if (num < LOTTO_PRICE) {
            throw new LessThanLottoPriceException();
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
