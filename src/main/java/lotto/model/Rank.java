package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 20000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    PASS(0, 0, false);

    private final int winningCount;
    private final int reward;
    private final boolean bonus;

    Rank(int winningCount, int reward, boolean bonus) {
        this.winningCount = winningCount;
        this.reward = reward;
        this.bonus = bonus;
    }

    public static Rank judge(int matchNumberCount, boolean bonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> isSameWinningCount(matchNumberCount, rank) && isSameBonusStatus(bonus, rank))
                .findFirst()
                .orElse(PASS);
    }

    private static boolean isSameBonusStatus(boolean bonus, Rank rank) {
        return rank.bonus == bonus;
    }

    private static boolean isSameWinningCount(int matchCount, Rank rank) {
        return rank.winningCount == matchCount;
    }

}
