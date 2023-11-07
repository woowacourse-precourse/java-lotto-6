package lotto.model;

public enum LottoRank {

    FIRST_RANK(6, false, 2_000_000_000L),
    SECOND_RANK(5, true, 30_000_000L),
    THIRD_RANK(5, false, 1_500_000L),
    FOURTH_RANK(4, false, 50_000L),
    FIFTH_RANK(3, false, 5_000L),
    NON_RANK(0, false, 0L);

    private final Integer matchedCount;
    private final boolean requireContainBonusNumber;
    private final Long prizeMoney;

    LottoRank(final Integer matchedCount, final boolean requireContainBonusNumber, final Long prizeMoney) {
        this.matchedCount = matchedCount;
        this.requireContainBonusNumber = requireContainBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public Integer getMatchedCount() {
        return matchedCount;
    }

    public boolean isRequireContainBonusNumber() {
        return requireContainBonusNumber;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }
}
