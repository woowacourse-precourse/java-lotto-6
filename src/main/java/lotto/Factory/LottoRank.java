package lotto.Factory;

public enum LottoRank {
    FIRST(6, "1등", 2_000_000_000),
    SECOND(5, "2등", 30_000_000),
    THIRD(5, "3등", 1_500_000),
    FOURTH(4, "4등", 50_000),
    FIFTH(3, "5등", 5_000),
    NONE(0, "꽝", 0);

    private final int matchCount;
    private final String rankName;
    private final long prizeMoney;

    LottoRank(int matchCount, String rankName, long prizeMoney) {
        this.matchCount = matchCount;
        this.rankName = rankName;
        this.prizeMoney = prizeMoney;
    }


}
