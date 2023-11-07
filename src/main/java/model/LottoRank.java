package model;

public enum LottoRank {

    FIFTH(3, BonusBallCondition.NON_REGARD, 5000),
    FORTH(4, BonusBallCondition.NON_REGARD, 50000),
    THIRD(5, BonusBallCondition.MISMATCH, 1500000),
    SECOND(5, BonusBallCondition.MATCH, 30000000),
    FIRST(6, BonusBallCondition.NON_REGARD, 2000000000);

    private final int equalCount;
    private final BonusBallCondition condition;
    private final long reward;

    LottoRank(final int equalCount, final BonusBallCondition condition, final long reward) {
        this.equalCount = equalCount;
        this.condition = condition;
        this.reward = reward;
    }

    public boolean hasSameCount(final long count) {
        return count == equalCount;
    }

    public boolean hasSameBonusBallCondition(final boolean hasSameBonusBall) {
        if (hasSameBonusBall) {
            return condition.equals(BonusBallCondition.MATCH);
        }
        return condition.equals(BonusBallCondition.MISMATCH);
    }

    public long getReward() {
        return reward;
    }

    public int getEqualCount() {
        return equalCount;
    }

    public boolean mustSameBonusBall() {
        return condition.equals(BonusBallCondition.MATCH);
    }
}
