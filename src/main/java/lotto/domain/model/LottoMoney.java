package lotto.domain.model;

import lotto.constant.IllegalArgumentExceptionType;

public class LottoMoney {

    static final int ZERO = 0;
    static final int LOTTO_PRICE = 1000;
    static final int MAX_AMOUNT = 2_000_000_000; // 20억. Integer의 범위에 근접한 수
    private final long amount;

    public LottoMoney(long amount) {
        this.amount = amount;
        validateRemains();
        validateMinPrice();
        validateMaxPrice();
    }

    private boolean hasRemain() {
        return amount % LOTTO_PRICE != ZERO;
    }

    private void validateMinPrice() {
        if (amount < LOTTO_PRICE) {
            throw IllegalArgumentExceptionType.INSUFFICIENT_MONEY.getException();
        }
    }
    private void validateMaxPrice() {
        if (amount > MAX_AMOUNT) {
            throw IllegalArgumentExceptionType.MAX_MONEY_EXCEEDED.getException();
        }
    }

    void validateRemains() {
        if (hasRemain()) {
            throw IllegalArgumentExceptionType.MONEY_REMAINS_EXIST.getException();
        }
    }

    long getBuyAmount() {
        return amount / LOTTO_PRICE;
    }
}
