package lotto.config;

public enum Prize {

    NONE(0, 0),
    THREE_NUMBER_MATCH(3, 5000),
    FOUR_NUMBER_MATCH(4, 50000),
    FIVE_NUMBER_MATCH(5, 1500000),
    FIVE_NUMBER_AND_BONUS_NUMBER_MATCH(5, 30000000),
    SIX_NUMBER_MATCH(6, 2000000000);

    private final int matchingNumberCount;
    private final int prizeMoney;

    Prize(int matchingNumberCount, int prizeMoney) {
        this.matchingNumberCount = matchingNumberCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
