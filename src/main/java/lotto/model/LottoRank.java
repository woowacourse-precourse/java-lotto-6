package lotto.model;

public enum LottoRank {

    FIRST_RANK(6, false, 2_000_000_000L),
    SECOND_RANK(5, true, 30_000_000L),
    THIRD_RANK(5, false, 1_500_000L),
    FOURTH_RANK(4, false, 50_000L),
    FIFTH_RANK(3, false, 5_000L),
    NON_RANK(0, false, 0L);

    private final Integer matchedCount;
    private final boolean includeBonus;
    private final Long prizeMoney;

    LottoRank(final Integer matchedCount, final boolean includeBonus, final Long prizeMoney) {
        this.matchedCount = matchedCount;
        this.includeBonus = includeBonus;
        this.prizeMoney = prizeMoney;
    }

    public Integer getMatchedCount() {
        return matchedCount;
    }

    public boolean isIncludeBonus() {
        return includeBonus;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }
}
