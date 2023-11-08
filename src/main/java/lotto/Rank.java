package lotto;

public enum Rank {
    FIRST(1, 6, false, 2000000000),
    SECOND(2,5, true, 30000000),
    THIRD(3, 5, false, 1500000),
    FOURTH(4, 4, false, 50000),
    FIFTH(5, 3, false, 5000),
    OUT_OF_RANK(0,0, false, 0);

    private final int rankNumber;
    private final int match;
    private final boolean isBonus;
    private final int reward;

    Rank (int  rankNumber, int match, boolean isBonus, int reward) {
        this.rankNumber = rankNumber;
        this.match = match;
        this.isBonus = isBonus;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }
}
