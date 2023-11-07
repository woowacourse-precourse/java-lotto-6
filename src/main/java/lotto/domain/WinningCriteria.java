package lotto.domain;

public enum WinningCriteria {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final Integer match;
    private final Boolean bonusMatch;
    private final int reward;

    WinningCriteria(int match, Boolean bonusMatch, int reward) {
        this.match = match;
        this.bonusMatch = bonusMatch;
        this.reward=reward;
    }

    public int getReward() {
        return reward;
    }

    public Integer getMatch() {
        return match;
    }
}
