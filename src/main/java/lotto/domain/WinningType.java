package lotto.domain;

import java.util.Arrays;

public enum WinningType {

    THREE(3, false, 5_000),
    FOUR(4, false, 50_000),
    FIVE(5, false, 1_500_000),
    FIVE_BONUS(5, true, 30_000_000),
    SIX(6, false, 2_000_000_000);

    private final int matchesNumber;
    private final boolean isBonus;
    private final int reward;

    WinningType(int matchesNumber, boolean isBonus, int reward) {
        this.matchesNumber = matchesNumber;
        this.isBonus = isBonus;
        this.reward = reward;
    }

    public static WinningType of(int count, boolean isBonusMatch) {
        return Arrays.stream(WinningType.values())
                .filter(winningType -> isBonusMatch)
                .filter(winningType -> winningType.matchesNumber == count)
                .findAny()
                .orElse(null);
    }

    public int getMatchesCount() {
        return matchesNumber;
    }

    public int getReward() {
        return reward;
    }
}
