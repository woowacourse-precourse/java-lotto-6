package lotto.model;

public enum WinningCriteria {
    FIRST(6, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);
    private Integer matchingNumberCount;
    private boolean matchBonusNumber;
    private int prizeAmount;

    WinningCriteria(int matchingNumberCount, int prizeAmount) {
        this(matchingNumberCount, false, prizeAmount);
    }

    WinningCriteria(int matchingNumberCount, boolean matchBonusNumber, int prizeAmount) {
        this.matchingNumberCount = matchingNumberCount;
        this.matchBonusNumber = matchBonusNumber;
        this.prizeAmount = prizeAmount;
    }

    public Integer getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean matchNumberCount(int matchingNumberCount) {
        return this.matchingNumberCount.equals(matchingNumberCount);
    }
}
