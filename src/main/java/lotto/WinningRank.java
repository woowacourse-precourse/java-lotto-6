package lotto;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum WinningRank {

    NO_WIN(0, false, 0, (count, bonus) -> count <= 0),
    FIFTH(3, false, 5_000, (count, bonus) -> count == 3),
    FOURTH(4, false, 50_000, (count, bonus) -> count == 4),
    THIRD(5, false, 1_500_000, (count, bonus) -> count == 5 && !bonus),
    SECOND(5, true, 30_000_000, (count, bonus) -> count == 5 && bonus),
    FIRST(6, false, 2_000_000_000, (count, bonus) -> count == 6);

    private final int countOfMatchingNumbers;
    private final boolean requiresBonus;
    private final long prize;
    private final BiFunction<Integer, Boolean, Boolean> conditionExpress;

    WinningRank(int countOfMatchingNumbers, boolean requiresBonus, long prize, BiFunction<Integer, Boolean, Boolean> conditionExpress) {
        this.countOfMatchingNumbers = countOfMatchingNumbers;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
        this.conditionExpress = conditionExpress;
    }

    public int getCountOfMatchingNumbers() {
        return countOfMatchingNumbers;
    }

    public boolean isRequiresBonus() {
        return requiresBonus;
    }

    public long getPrize() {
        return prize;
    }

    public static WinningRank from(int count, boolean bonus) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.isRank(count, bonus))
                .findFirst()
                .orElse(NO_WIN);
    }

    private boolean isRank(int countOfMatchingNumbers, boolean isBonusMatched) {
        return conditionExpress.apply(countOfMatchingNumbers, isBonusMatched);
    }

}

