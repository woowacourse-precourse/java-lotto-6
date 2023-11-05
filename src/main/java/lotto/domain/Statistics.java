package lotto.domain;

import java.util.Arrays;

public enum Statistics {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000),
    NON(0,0);

    private int count;
    private int amount;

    Statistics(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

    public static Statistics getStatistics(int matchCount) {
        return Arrays.stream(Statistics.values())
                .filter(data -> data.count == matchCount).findAny().orElse(NON);
    }
}
