package lotto.domain;

import java.util.function.BiFunction;

public enum Rank {
    FIRST(6, 2_000_000_000, (count, bonus) -> count == 6),
    SECOND(5, 30_000_000, (count, bonus) -> count == 5 && bonus),
    THIRD(5, 1_500_000, (count, bonus) -> count == 5 && !bonus),
    FOURTH(4, 50_000, (count, bonus) -> count == 4),
    FIFTH(3, 5_000, (count, bonus) -> count == 3),
    NONE(0, 0, (count, bonus) -> count <= 2);


    private final int count;
    private final long prize;
    private final BiFunction<Integer, Boolean, Boolean> expression;

    Rank(int count, long prize, BiFunction<Integer, Boolean, Boolean> expression) {
        this.count = count;
        this.prize = prize;
        this.expression = expression;
    }

    public int getCount() {
        return count;
    }

    public long getPrize() {
        return prize;
    }
    public boolean result(int count, boolean bonus) {
        return expression.apply(count, bonus);
    }
}

