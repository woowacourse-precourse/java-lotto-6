package lotto.Domain;

public enum Result {

    RANK_FIRST(1, 6, false, "2,000,000,000"),
    RANK_SECOND(2, 5, true, "30,000,000"),
    RANK_THIRD(3, 5, false, "1,500,000"),
    RANK_FOURTH(4, 4, false, "50,000"),
    RANK_FIFTH(5, 3, false, "5,000");

    private final int rank;
    private final int hitCount;
    private final boolean isBonusHit;
    private final String reward;

    Result(int rank, int hitCount, boolean isBonusHit, String reward) {
        this.rank = rank;
        this.hitCount = hitCount;
        this.isBonusHit = isBonusHit;
        this.reward = reward;
    }

    public int getRank() {
        return this.rank;
    }

    public int getHitCount() {
        return this.hitCount;
    }

    public boolean getIsBonusHit() {
        return this.isBonusHit;
    }

    public String getReward() {
        return this.reward;
    }
}