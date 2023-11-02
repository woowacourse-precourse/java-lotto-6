package lotto.constant;

public enum LottoPrize {
    FIFTH(3, 5_000L, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, 50_000L, "4개 일치 (50,000원) - %d개"),
    THIRD(5, 1_500_000L, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, 2_000_000_000L, "6개 일치 (2,000,000,000원) - %d개"),
    NOTHING(0, 0L, "");

    private int matchedCount;
    private Long prize;
    private String statisticsFormat;

    LottoPrize(int matchedCount, long prize, String statisticsFormat) {
        this.matchedCount = matchedCount;
        this.prize = prize;
        this.statisticsFormat = statisticsFormat;
    }

    public Long getPrize() {
        return prize;
    }

    public String getStatisticsFormat() {
        return statisticsFormat;
    }
}
