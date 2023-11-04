package lotto.constants;

public enum LottoPrize {

    FIRST_PRIZE(6, 2000000000, false),
    SECOND_PRIZE(5, 30000000, true),
    THIRD_PRIZE(5, 1500000, false),
    FOURTH_PRIZE(4, 50000, false),
    FIFTH_PRIZE(3, 5000, false);

    private final Integer matchedNumberCount;
    private final Integer prizeMoney;
    private final Boolean isBonusNumberMatch;

    LottoPrize(Integer matchedNumberCount, Integer prizeMoney, Boolean isBonusNumberMatch) {
        this.matchedNumberCount = matchedNumberCount;
        this.prizeMoney = prizeMoney;
        this.isBonusNumberMatch = isBonusNumberMatch;
    }

    public Integer getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    public Boolean getBonusNumberMatch() {
        return isBonusNumberMatch;
    }
}
