package lotto.domain;

public enum Prize {
    THIRD_MATCH(3, 5000, "3개 일치"),
    FOURTH_MATCH(4, 50000, "4개 일치"),
    FIFTH_MATCH(5, 1500000, "5개 일치"),
    SIXTH_MATCH(6, 2000000000, "6개 일치"),
    FIFTH_AND_BONUS_MATCH(7, 30000000, "5개 일치, 보너스 볼 일치");

    private final int matchingCount;
    private final long prizeAmount;
    private final String description;

    Prize(int matchingCount, long prizeAmount, String description) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
        this.description = description;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public String getDescription() {
        return description;
    }
}
