package lotto.model;

public enum PrizeRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchingNumbers;
    private final int prizeMoney;

    PrizeRank(int matchingNumbers, int prizeMoney) {
        this.matchingNumbers = matchingNumbers;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static PrizeRank valueOf(int matchingNumbers, boolean hasBonusNumber) {
        for (PrizeRank rank : PrizeRank.values()) {
            if (rank.matchingNumbers == matchingNumbers && (!rank.equals(SECOND) || hasBonusNumber)) {
                return rank; //2등일때만 hasBonusNumber 조건이 And가 됨
            }
        }
        return NONE;
    }
}
