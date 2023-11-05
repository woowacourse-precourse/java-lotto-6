package lotto.domain;

import java.util.Arrays;

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

    public static LottoRank findRank(int matchingCount, boolean hasBonusNumber) {
        if (matchingCount == 5) {
            if (hasBonusNumber) {
                return SECOND;
            }
            return THIRD;
        }
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getRankMatchCount() == matchingCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("맞힌 개수와 일치하는 Rank가 없습니다"));
    }

    public int getRankMatchCount() {
        return rankMatchCount;
    }
}
