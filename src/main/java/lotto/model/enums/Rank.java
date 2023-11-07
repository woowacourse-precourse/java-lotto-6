package lotto.model.enums;

public enum Rank {
    RANK1(1, 6),
    RANK2(2, 5, true),
    RANK3(3, 5, false),
    RANK4(4, 4),
    RANK5(5, 3),
    NO_RANK(-1, 0);

    private final int rank;
    private final int matchingNumbers;
    private final boolean bonusMatch;

    Rank(int rank, int matchingNumbers) {
        this(rank, matchingNumbers, false);
    }

    Rank(int rank, int matchingNumbers, boolean bonusMatch) {
        this.rank = rank;
        this.matchingNumbers = matchingNumbers;
        this.bonusMatch = bonusMatch;
    }

    public boolean isMatch(int matchingNumber, boolean bonusMatch) {
        return this.matchingNumbers == matchingNumber && this.bonusMatch == bonusMatch;
    }

    public int getRank() {
        return this.rank;
    }
}
