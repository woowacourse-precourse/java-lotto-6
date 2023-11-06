package lotto;

public enum PrizeGrade {
    FIRST(6, 2000000000, EMPTY),
    SECOND(5, 30000000, EMPTY),
    THIRD(5, 1500000, ", 보너스 볼 일치"),
    FOURTH(4, 50000, EMPTY),
    FIFTH(3, 5000, EMPTY),
    NO_PRIZE(0, 0, EMPTY);

    private final int matchCount;
    private final int prizeMoney;
    private final String additionalMessage;

    PrizeGrade(int matchCount, int prizeMoney, String additionalMessage) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.additionalMessage = additionalMessage;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public String getAdditionalMessage() {
        return this.additionalMessage;
    }
}
