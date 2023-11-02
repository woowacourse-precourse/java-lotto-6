package constant;

public enum LottoPrize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchingCounts;
    private final int prize;

    LottoPrize(int matchingCounts, int prize) {
        this.matchingCounts = matchingCounts;
        this.prize = prize;
    }

    public int getMatchingCounts() {
        return matchingCounts;
    }

    public int getPrize() {
        return prize;
    }
}
