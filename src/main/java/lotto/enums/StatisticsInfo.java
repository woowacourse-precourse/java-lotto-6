package lotto.enums;

public enum StatisticsInfo {
    RANK_1(1, 6, 2000000000, "6개 일치 (2,000,000,000원) - %d개"),
    RANK_2(2, 5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    RANK_3(3, 5, 1500000, "5개 일치 (1,500,000원) - %d개"),
    RANK_4(4, 4, 50000, "4개 일치 (50,000원) - %d개"),
    RANK_5(5, 3, 5000, "3개 일치 (5,000원) - %d개"),
    ;

    private final int rank;
    private final int matchCount;
    private final int prizeMoney;
    private final String message;

    StatisticsInfo(int rank, int matchCount, int prizeMoney, String message) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMsg() {
        return message;
    }

    public static int getOrdinalByMatchCount(int matchCount) {
        if (matchCount == RANK_3.matchCount) {
            return RANK_3.ordinal();
        }
        for (StatisticsInfo info : values()) {
            if (info.matchCount == matchCount) {
                return info.ordinal();
            }
        }
        return -1;
    }
}
