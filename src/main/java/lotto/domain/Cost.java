package lotto.domain;

import static lotto.global.constants.NumberType.COST_UNIT;

public class Cost {
    private int cost;

    private Cost(int cost) {
        this.cost = cost;
    }

    public static Cost from(int cost) {
        return new Cost(cost);
    }

    public int getCount() {
        return cost / COST_UNIT.getValue();
    }
}
