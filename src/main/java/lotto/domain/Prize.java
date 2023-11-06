package lotto.domain;

import java.util.function.Function;

public enum Prize {

    EMPTY(6, 0, money -> money),
    FIFTH(5, 3, money -> money + 5000),
    FOURTH(4, 4, money -> money + 50000),
    THIRD(3, 5, money -> money + 1500000),
    SECOND(2, 5, money -> money + 30000000),
    FIRST(1, 6, money -> money + 200000000);

    private int rank;
    private int matched;
    private Function<Long, Long> expression;

    Prize(int rank, int matched, Function<Long, Long> expression) {
        this.rank = rank;
        this.matched = matched;
        this.expression = expression;
    }

    public long calculate(long amount) {
        return expression.apply(amount);
    }

    public int getRank() {
        return rank;
    }

    public int getMatched() {
        return matched;
    }
}
