package lotto.domain;

import java.util.Arrays;

public enum WinningRank {

    ONE("1등", 6, 2000000000),
    TWO("2등", 5, 30000000),
    THREE("3등", 5, 1500000),
    FOUR("4등", 4, 50000),
    FIVE("5등", 3, 5000);

    private static final String INVALID_COUNT_EXCEPTION = "존재하지 않는 당첨 개수입니다.";

    private final String ranking;
    private final int count;
    private final int reward;

    WinningRank(String ranking, int count, int reward) {
        this.ranking = ranking;
        this.count = count;
        this.reward = reward;
    }

    public static WinningRank find(int count) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.count == count)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COUNT_EXCEPTION));
    }
}
