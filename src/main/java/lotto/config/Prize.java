package lotto.config;

public enum Prize {

    THREE_NUMBER_MATCH(3, 5000),
    FOUR_NUMBER_MATCH(4, 50000),
    FIVE_NUMBER_MATCH(5, 1500000),
    FIVE_NUMBER_AND_BONUS_NUMBER_MATCH(6, 30000000),
    SIX_NUMBER_MATCH(6, 2000000000);

    private final int matchingNumberCount;
    private final int prize;

    Prize(int matchingNumberCount, int prize) {
        this.matchingNumberCount = matchingNumberCount;
        this.prize = prize;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public int getPrize() {
        return prize;
    }
}
