package lotto;

public enum Prize {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000),
    SIX_MATCH(6, 2_000_000_000);

    private int matchNumbers;
    private int prizeAmount;
    private int matchCount;

    Prize(int matchNumbers, int prizeAmount) {
        this.matchNumbers = matchNumbers;
        this.prizeAmount = prizeAmount;
        this.matchCount = 0;
    }
    public int getMatchNumbers() {
        return matchNumbers;
    }
    public int getPrizeAmount() {
        return prizeAmount;
    }
    public void increaseMatchCount() {
        this.matchCount++;
    }
    public int getMatchCount() {
        return matchCount;
    }
    public static int matchPrize(int numberOfMatches, boolean hasBonus) {
        for (Prize prize : values()) {
            if (prize.matchNumbers == numberOfMatches) {
                if (hasBonus && prize == FIVE_MATCH) {
                    return FIVE_MATCH_WITH_BONUS.prizeAmount;
                }
                prize.increaseMatchCount();
                return prize.prizeAmount;
            }

        }
        return 0;
    }
}
