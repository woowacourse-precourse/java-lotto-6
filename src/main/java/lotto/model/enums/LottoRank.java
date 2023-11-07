package lotto.model.enums;

public enum LottoRank {
    RANK1(1, 6),
    RANK2(2, 5, true),
    RANK3(3, 5, false),
    RANK4(4, 4),
    RANK5(5, 3);

    private final int rank;
    private final int matchingNumbers;
    private final boolean bonusMatch;

    LottoRank(int rank, int matchingNumbers) {
        this(rank, matchingNumbers, false);
    }

    LottoRank(int rank, int matchingNumbers, boolean bonusMatch) {
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
