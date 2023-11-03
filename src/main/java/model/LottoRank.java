package model;

public enum LottoRank {

    FIFTH(3, false, 5000),
    FORTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int equalCount;
    private final boolean bonusBallCondition;
    private final long reward;

    LottoRank(final int equalCount, final boolean bonusBallCondition, final long reward) {
        this.equalCount = equalCount;
        this.bonusBallCondition = bonusBallCondition;
        this.reward = reward;
    }

    public boolean hasSameCount(long count) {
        return count == equalCount;
    }

    public boolean hasSameBonusBallCondition(boolean bonusBallCondition) {
        return bonusBallCondition == this.bonusBallCondition;
    }

    public long getReward() {
        return reward;
    }

    public int getEqualCount() {
        return equalCount;
    }

    public boolean getBonusBallCondition() {
        return bonusBallCondition;
    }
}
