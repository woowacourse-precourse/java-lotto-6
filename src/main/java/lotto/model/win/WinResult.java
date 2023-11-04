package lotto.model.win;

public enum WinResult {
    FIFTH(3, 0, 5, 5000),
    FORTH(4, 0, 4, 50000),
    THIRD(5, 0, 3, 1500000),
    SECOND(5, 1, 2, 30000000),
    FIRST(6, 0, 1, 2000000000),
    FAIL(-1,-1,6,0);

    public int matchedCount;
    public int bonusCount;
    public int rank;
    public long reward;

    WinResult(int matchedCount, int bonusCount, int rank, long reward) {
        this.matchedCount = matchedCount;
        this.bonusCount = bonusCount;
        this.rank = rank;
        this.reward = reward;
    }
}
