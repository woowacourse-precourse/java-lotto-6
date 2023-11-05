package lotto.domain;

import lotto.view.constant.Exception;

public class Buyer {
    private final int cost;

    public Buyer(int cost) {
        validate(cost);
        this.cost = cost;
    }

    private void validate(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException(Exception.COST_MOD);
        }
    }
}
