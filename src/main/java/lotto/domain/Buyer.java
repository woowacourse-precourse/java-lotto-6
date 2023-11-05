package lotto.domain;

import lotto.view.constant.Exception;

public class Buyer {
    private final static int price = 1000;
    private final int cost;

    public Buyer(int cost) {
        validate(cost);
        this.cost = cost;
    }

    public int getBuyCount() {
        return this.cost / price;
    }

    private void validate(int cost) {
        if (cost % price != 0) {
            throw new IllegalArgumentException(Exception.COST_MOD);
        }
    }
}
