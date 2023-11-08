package lotto.domain;

import lotto.domain.dto.LottoNumberCompareResult;

public enum LottoRank {
    FIFTH_PLACE(3, false, 5_000),
    FOURTH_PLACE(4, false, 50_000),
    THIRD_PLACE(5, false, 1_500_000),
    SECOND_PLACE(5, true, 30_000_000),
    FIRST_PLACE(6, false, 2_000_000_000);

    private final int matchingCount;
    private boolean bonusIncluded;
    private int prizeAmount;

    LottoRank(int matchingCount, boolean bonusIncluded, int prizeAmount) {
        this.matchingCount = matchingCount;
        this.bonusIncluded = bonusIncluded;
        this.prizeAmount = prizeAmount;
    }

    public static LottoRank findLottoRank(LottoNumberCompareResult compareResult) {
        LottoRank lottoRank = null;

        for (LottoRank rank : LottoRank.values()) {
            if (rank.isEqual(compareResult.getMatchingCount(), compareResult.isBonusIncluded())) {
                lottoRank = rank;
            }
        }

        return lottoRank;
    }

    private boolean isEqual(int matchingCount, boolean bonusIncluded) {
        return this.matchingCount == matchingCount && this.bonusIncluded == bonusIncluded;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isBonusIncluded() {
        return bonusIncluded;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
