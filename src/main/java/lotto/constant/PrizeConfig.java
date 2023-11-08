package lotto.constant;

public enum PrizeConfig {
    FIRST(6, false, "2,000,000,000원"),
    SECOND(5, true, "30,000,000원"),
    THIRD(5, false, "1,500,000원"),
    FOURTH(4, false, "50,000원"),
    FIFTH(3, false, "5,000원");

    private final int matchingNumbers;
    private final boolean shouldBonusBallMatch;
    private final String reward;

    PrizeConfig(int matchingNumbers, boolean shouldBonusBallMatch, String reward) {
        this.matchingNumbers = matchingNumbers;
        this.shouldBonusBallMatch = shouldBonusBallMatch;
        this.reward = reward;
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
