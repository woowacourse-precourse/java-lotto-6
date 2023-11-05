package lotto.domain;

public enum LottoRank {

    FIFTH(3,5_000 ,"5,000"),
    FOURTH(4,50_000,"50,000"),
    THIRD(5,1_500_000,"1,500,000"),
    SECOND(5,30_000_000,"30,000,000"),
    FIRST(6,2_000_000_000,"2,000,000,000");

    private final int rankMatchCount;
    private final long prizeMoney;
    private final String prizeAsString;

    LottoRank(int rankMatchCount, long prizeMoney, String prizeAsString) {
        this.rankMatchCount = rankMatchCount;
        this.prizeMoney = prizeMoney;
        this.prizeAsString = prizeAsString;
    }
}
