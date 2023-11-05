package lotto.domain.model;

import lotto.constant.IllegalArgumentExceptionType;

public final class LottoPurchaseCost {
    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_AMOUNT = 2_000_000_000; // 20억. Integer.MAX_VALUE 에 근접한 수

    private final long cost;

    public LottoPurchaseCost(long cost) {
        validateRemains(cost);
        validateMinPrice(cost);
        validateMaxPrice(cost);
        this.cost = cost;
    }

    public long getCost() { return cost; }

    private boolean hasRemain(long amount) {
        return amount % LOTTO_PRICE != ZERO;
    }

    private void validateMinPrice(long amount) {
        if (amount < LOTTO_PRICE) {
            throw IllegalArgumentExceptionType.INSUFFICIENT_MONEY.getException();
        }
    }

    private void validateMaxPrice(long amount) {
        if (amount > MAX_AMOUNT) {
            throw IllegalArgumentExceptionType.MAX_MONEY_EXCEEDED.getException();
        }
    }

    private void validateRemains(long amount) {
        if (hasRemain(amount)) {
            throw IllegalArgumentExceptionType.MONEY_REMAINS_EXIST.getException();
        }
    }

    public int getLottoAmount() {
        return Long.valueOf(cost / LOTTO_PRICE).intValue();
    }
}
