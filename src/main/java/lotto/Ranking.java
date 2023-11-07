package lotto;

public enum Ranking {
    FRIST(6, 2000000000),
    SECOND(15, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int matchCount;
    private final int prizeMoney;

    Ranking(final int matchCount, final int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static int getPrizeMoney(final int userMatchCount) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.matchCount == userMatchCount) {
                return ranking.prizeMoney;
            }
        }

        return 0;
    }
}
