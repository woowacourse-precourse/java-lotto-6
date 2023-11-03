package lotto.domain;

public enum WinningStatistics {
    FIRST(6, 0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0, 50000),
    FIFTH(3, 0, 5000),
    MISS(0, 0, 0);

    private final int matchCount;
    private final int matchBonusCount;
    private final int reward;

    WinningStatistics(int matchCount, int matchBonusCount, int reward) {
        this.matchCount = matchCount;
        this.matchBonusCount = matchBonusCount;
        this.reward = reward;
    }
}
