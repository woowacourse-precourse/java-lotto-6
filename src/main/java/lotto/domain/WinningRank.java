package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum WinningRank {
    FIRST(6, List.of(false), 2_000_000_000, "6개 일치"),
    SECOND(5, List.of(true), 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, List.of(false), 1_500_000, "5개 일치"),
    FOURTH(4, List.of(true, false), 50_000, "4개 일치"),
    FIFTH(3, List.of(true, false), 5_000, "3개 일치"),
    NONE(0, List.of(false), 0, "NONE..."),
    ;

    private final int matchCount;
    private final List<Boolean> hasBonus;
    private final int reward;
    private final String description;

    WinningRank(
            final int matchCount,
            final List<Boolean> hasBonus,
            final int reward,
            final String description
    ) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.reward = reward;
        this.description = description;
    }

    public static WinningRank of(
            final int matchCount,
            final boolean hasBonus
    ) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.matchCount == matchCount)
                .filter(winningRank -> winningRank.hasBonus.contains(hasBonus))
                .findFirst()
                .orElse(NONE);
    }

    public int getReward() {
        return reward;
    }

    public String getDescription() {
        return description;
    }
}
