package lotto.constant;

public enum RankConfig {
    FIRST(1, 6, false, "2,000,000,000원"),
    SECOND(2, 5, true, "30,000,000원"),
    THIRD(3, 5, false, "1,500,000원"),
    FOURTH(4, 4, false, "50,000원"),
    FIFTH(5, 3, false, "5,000원");

    private final int rank;
    private final int matchingNumbers;
    private final boolean shouldBonusBallMatch;
    private final String reward;

    RankConfig(int rank, int matchingNumbers, boolean shouldBonusBallMatch, String reward) {
        this.rank = rank;
        this.matchingNumbers = matchingNumbers;
        this.shouldBonusBallMatch = shouldBonusBallMatch;
        this.reward = reward;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public boolean isShouldBonusBallMatch() {
        return shouldBonusBallMatch;
    }

    public String getReward() {
        return reward;
    }
}
