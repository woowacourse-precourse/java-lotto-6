package lotto.enumerate;

import java.util.function.Function;

public enum Rank {
    FIRST_PLACE(value -> (long) (value * 2000000000)),
    SECOND_PLACE(value -> (long) (value * 30000000)),
    THIRD_PLACE(value -> (long) (value * 1500000)),
    FOURTH_PLACE(value -> (long) (value * 50000)),
    FIFTH_PLACE(value -> (long) (value * 5000));
    private final Function<Integer, Long> expression;

    Rank(Function<Integer, Long> expression) {
        this.expression = expression;
    }

    public long calculate(int value) {
        return expression.apply(value);
    }
}
