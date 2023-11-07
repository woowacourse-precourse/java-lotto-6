package lotto.domain;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),
    SECOND(6, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private int matchingNumbers;
    private long prize;

    LottoPrize(int matchingNumbers, int prize) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public long getPrize() {
        return prize;
    }
}
