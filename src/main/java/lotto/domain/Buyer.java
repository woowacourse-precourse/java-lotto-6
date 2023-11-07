package lotto.domain;

import lotto.view.constant.Exception;

public class Buyer {
    private static final int PRICE = 1000;
    private static final int MOD = 0;
    private final int cost;

    public Buyer(int cost) {
        validate(cost);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getBuyCount() {
        return this.cost / PRICE;
    }

    private void validate(int cost) {
        if (cost < PRICE) {
            throw new IllegalArgumentException(Exception.COST_MIN);
        }
        if (cost % PRICE != MOD) {
            throw new IllegalArgumentException(Exception.COST_MOD);
        }
    }
}
