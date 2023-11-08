package lotto;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NO_WIN(0, 0, false);

    private final int matchingCount;
    private final int amount;

    private final boolean matchBonusNumber;

    LottoRank(int matchingCount, int amount, boolean matchBonusNumber) {
        this.matchingCount = matchingCount;
        this.amount = amount;
        this.matchBonusNumber = matchBonusNumber;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getMatchBonusNumber() {
        return matchBonusNumber;
    }

    public static LottoRank getRank(int matchingCount, boolean matchBonusNumber) {
        if (matchingCount == 6) {
            return LottoRank.FIRST;
        } else if (matchingCount == 5 && matchBonusNumber) {
            return LottoRank.SECOND;
        } else if (matchingCount == 5) {
            return LottoRank.THIRD;
        } else if (matchingCount == 4) {
            return LottoRank.FOURTH;
        } else if (matchingCount == 3) {
            return LottoRank.FIFTH;
        }

        return LottoRank.NO_WIN;
    }
}
