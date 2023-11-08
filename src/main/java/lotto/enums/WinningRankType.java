package lotto.enums;

import java.util.Arrays;
import java.util.function.Function;

public enum WinningRankType {
    FIRST_PLACE(6, 0, count -> count * 2000000000),
    SECOND_PLACE(5, 1, count -> count * 30000000),
    THIRD_PLACE(5, 0, count -> count * 1500000),
    FOURTH_PLACE(4, 0, count -> count * 50000),
    FIFTH_PLACE(3, 0, count -> count * 5000),
    NO_RANK(0, 0, count -> 0);

    private int winningCondition;
    private int bonusCondition;
    private Function<Integer, Integer> prizeExpression;

    WinningRankType(int winningCondition, int bonusCondition, Function<Integer, Integer> prizeExpression) {
        this.winningCondition = winningCondition;
        this.bonusCondition = bonusCondition;
        this.prizeExpression = prizeExpression;
    }

    public static WinningRankType selectRankingType(int winningCount, int bonusCount) {
        return Arrays.stream(WinningRankType.values())
                .filter(ranking -> isMatchedRanking(ranking, winningCount, bonusCount))
                .findFirst()
                .orElse(NO_RANK);
    }

    private static boolean isMatchedRanking(WinningRankType ranking, int winningCount, int bonusCount) {
        return (ranking.winningCondition <= winningCount)
                &&
                (ranking.bonusCondition <= bonusCount);
    }

    public int calculateWinnings(int count) {
        return prizeExpression.apply(count);
    }
}
