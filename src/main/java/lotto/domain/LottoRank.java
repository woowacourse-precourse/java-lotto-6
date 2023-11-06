package lotto.domain;

public enum LottoRank {
    FIRST_PLACE(6, false, 2_000_000_000),
    SECOND_PLACE(5, true, 30_000_000),
    THIRD_PLACE(5, false, 1_500_000),
    FOURTH_PLACE(4, false, 50_000),
    FIFTH_PLACE(3, false, 5_000);

    private final int matchingCount;
    private boolean bonusIncluded;
    private int prizeAmount;

    LottoRank(int matchingCount, boolean bonusIncluded, int prizeAmount) {
        this.matchingCount = matchingCount;
        this.bonusIncluded = bonusIncluded;
        this.prizeAmount = prizeAmount;
    }
}
