package lotto.model.enums;

public enum PrizeInfo {
    NO_PRIZE(0, 0, 0),
    PRIZE_1(1, 2000000000, 6, false),
    PRIZE_2(2, 30000000, 5, true),
    PRIZE_3(3, 1500000, 5, false),
    PRIZE_4(4, 50000, 4, false),
    PRIZE_5(5, 5000, 3, false),
    PRIZE_3_TRUE(3, 1500000, 5, true),
    PRIZE_4_TRUE(4, 50000, 4, true),
    PRIZE_5_TRUE(5, 5000, 3, true);

    private final int rank;
    private final long prize;
    private final int matchingNumbers;
    private final boolean bonusMatch;

    PrizeInfo(int rank, long prize, int matchingNumbers) {
        this(rank, prize, matchingNumbers, false);
    }

    PrizeInfo(int rank, long prize, int matchingNumbers, boolean bonusMatch) {
        this.rank = rank;
        this.prize = prize;
        this.matchingNumbers = matchingNumbers;
        this.bonusMatch = bonusMatch;
    }

    public boolean isMatch(int matchingNumber, boolean bonusMatch) {
        return this.matchingNumbers == matchingNumber && this.bonusMatch == bonusMatch;
    }

    public int getRank() {
        return this.rank;
    }

    public long getPrize() {
        return this.prize;
    }
}
