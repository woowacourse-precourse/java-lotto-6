package lotto.common.constants;

public enum LottoRank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchingNumbersCount;
    private final boolean hasBonusBall;
    private final int prize;

    LottoRank(int matchingNumbersCount, boolean hasBonusBall, int prize) {
        this.matchingNumbersCount = matchingNumbersCount;
        this.hasBonusBall = hasBonusBall;
        this.prize = prize;
    }

    public int getMatchingNumbersCount() {
        return matchingNumbersCount;
    }

    public boolean hasBonusBall() {
        return hasBonusBall;
    }

    public int getPrize() {
        return prize;
    }
}
