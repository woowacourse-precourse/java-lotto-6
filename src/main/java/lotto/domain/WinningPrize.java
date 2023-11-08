package lotto.domain;

public enum WinningPrize {
    FIRST_PRIZE(6, 2000000000L, "2,000,000,000"),
    SECOND_PRIZE(5, 30000000L, "30,000,000"),
    THIRD_PRIZE(5, 1500000L, "1,500,000"),
    FOURTH_PRIZE(4, 50000L, "50,000"),
    FIFTH_PRIZE(3, 5000L, "5,000");


    private final int matchedNumberCount;
    private final long prizeMoney;
    private final String formatNumber;

    WinningPrize(int matchedNumberCount, long prizeMoney, String formatNumber) {
        this.matchedNumberCount = matchedNumberCount;
        this.prizeMoney = prizeMoney;
        this.formatNumber = formatNumber;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getFormatNumber() {
        return formatNumber;
    }



}
