package lotto.domain;

public enum LottoEnum {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int matchingCount;
    private final int prizeAmount;

    LottoEnum(int matchingCount, int prizeAmount) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}