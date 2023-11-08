package lotto;

public enum Ranking {
    FIRST(0, 2000000000),
    SECOND(1, 30000000),
    THIRD(2, 1500000),
    FOURTH(3, 50000),
    FIFTH(4, 5000);

    private final int matchCountIdx;
    private final int prizeMoney;

    Ranking(final int matchCountIdx, final int prizeMoney) {
        this.matchCountIdx = matchCountIdx;
        this.prizeMoney = prizeMoney;
    }

    public static int getPrizeMoney(final int userMatchCountIdx) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.matchCountIdx == userMatchCountIdx) {
                return ranking.prizeMoney;
            }
        }

        return 0;
    }
}
