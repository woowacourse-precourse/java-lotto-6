package lotto.domain;


public enum Rank {
    FIRST(6, 2_000_000_000,4),
    SECOND(5, 30_000_000,3),
    THIRD(5, 1_500_000,2),
    FOURTH(4, 50_000,1),
    FIFTH(3, 5_000,0),
    Null(0,0, 5);

    private final int matchingCount;
    private final int prizeAmount;
    private final int result;

    Rank(int matchingCount, int prizeAmount, int result) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
        this.result = result;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
    public int getResult() {
        return result;
    }
}
