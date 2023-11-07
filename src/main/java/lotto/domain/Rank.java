package lotto.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Rank {
    FIFTH(5000, 3, (count, hasBonusNumber) -> count == 3),
    FOURTH(50000, 4, (count, hasBonusNumber) -> count == 4),
    THIRD(1500000, 5, (count, hasBonusNumber) -> count == 5 && !hasBonusNumber),
    SECOND(30000000, 5, (count, hasBonusNumber) -> count == 5 && hasBonusNumber),
    FIRST(2000000000, 6, (count, hasBonusNumber) -> count == 6);

    private final int winningAmount;
    private final int count;
    private final BiFunction<Integer, Boolean, Boolean> expression;

    Rank(int winningAmount, int count,
         BiFunction<Integer, Boolean, Boolean> expression) {
        this.winningAmount = winningAmount;
        this.count = count;
        this.expression = expression;
    }

    public static Rank getRank(int count, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.expression.apply(count, hasBonusNumber))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return count;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}