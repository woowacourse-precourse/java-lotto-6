package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum WinningRank {

    ONE("1등", 6, 2000000000, List.of(true, false)),
    TWO("2등", 5, 30000000, List.of(true)),
    THREE("3등", 5, 1500000, List.of(false)),
    FOUR("4등", 4, 50000, List.of(true, false)),
    FIVE("5등", 3, 5000, List.of(true, false));

    private static final String INVALID_COUNT_EXCEPTION = "존재하지 않는 당첨 개수입니다.";

    private final String ranking;
    private final int count;
    private final int reward;
    private final List<Boolean> bonusMatchCases;

    WinningRank(String ranking, int count, int reward, List<Boolean> bonusMatchCases) {
        this.ranking = ranking;
        this.count = count;
        this.reward = reward;
        this.bonusMatchCases = bonusMatchCases;
    }

    public static WinningRank find(int count, boolean isBonusMatch) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.count == count && winningRank.bonusMatchCases.contains(isBonusMatch))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COUNT_EXCEPTION));
    }
}
