package lotto.domain;

import java.util.Arrays;

import static lotto.constants.ErrorMessageConstants.NO_MATCHING_RANK;
import static lotto.constants.LottoConstants.SECOND_OR_THIRD_MATCHING_COUNT;

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
        if (matchingCount == SECOND_OR_THIRD_MATCHING_COUNT) {
            if (hasBonusNumber) {
                return SECOND;
            }
            return THIRD;
        }

        LottoRank matchingRank  = findRankByMatchingCount(matchingCount);
        return matchingRank;
    }

    public int getRankMatchCount() {
        return rankMatchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeAsString() {
        return prizeAsString;
    }

    private static LottoRank findRankByMatchingCount(int matchingCount) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getRankMatchCount() == matchingCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NO_MATCHING_RANK));
    }
}
