package lotto;

public enum MatchType {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_WITH_BONUS(5, 30000000),
    SIX(6, 200000000);

    private final int matchingNumbers;
    private final int prize;

    MatchType(int matchingNumbers, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrize() {
        return prize;
    }
}
