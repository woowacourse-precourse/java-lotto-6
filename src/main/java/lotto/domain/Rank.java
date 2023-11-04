package lotto.domain;

public enum Rank {
    FIFTH(3, false, 5, 5000),
    FORTH(4, false, 4, 50000),
    THIRD(5, false, 3, 1500000),
    SECOND(5, true, 2, 30000000),
    FIRST(6, false, 1, 2000000000),
    FAIL(-1, false, 6, 0);

    public int matchedCount;
    public boolean bonus;
    public int rank;
    public long reward;

    Rank(int matchedCount, boolean bonus, int rank, long reward) {
        this.matchedCount = matchedCount;
        this.bonus = bonus;
        this.rank = rank;
        this.reward = reward;
    }
}
