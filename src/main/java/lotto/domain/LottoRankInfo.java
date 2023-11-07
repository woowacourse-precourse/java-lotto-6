package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRankInfo {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_WIN(0, 0);

    private static final int MINIMUM_WINNING_MATCHING_COUNT = 3;

    private final int matchingCount;
    private final int prizeMoney;

    LottoRankInfo(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static List<LottoRankInfo> getRankInfoByList() {
        List<LottoRankInfo> lottoRankInfos = Stream.of(LottoRankInfo.values())
                .filter(rank -> rank.matchingCount >= MINIMUM_WINNING_MATCHING_COUNT)
                .collect(Collectors.toList());
        Collections.reverse(lottoRankInfos);
        return lottoRankInfos;
    }

    public static LottoRankInfo getLottoRankInfo(int matchingCount, boolean matchingBonus) {
        return Arrays.stream(LottoRankInfo.values())
                .filter(rankInfo -> rankInfo.findRankInfo(rankInfo, matchingCount, matchingBonus))
                .findAny()
                .orElse(NO_WIN);
    }

    private boolean findRankInfo(LottoRankInfo rankInfo, int matchingCount, boolean matchingBonus) {
        boolean matchCountEqual = isMatchCountEqual(matchingCount, rankInfo.matchingCount);

        if (isSecondRank(rankInfo)) {
            return matchCountEqual && matchingBonus;
        }

        if (isThirdRank(rankInfo)) {
            return matchCountEqual && !matchingBonus;
        }

        return matchCountEqual;
    }

    private boolean isSecondRank(LottoRankInfo rankInfo) {
        return rankInfo.equals(SECOND);
    }

    private boolean isThirdRank(LottoRankInfo rankInfo) {
        return rankInfo.equals(THIRD);
    }

    private boolean isMatchCountEqual(int matchingCount, int expectedMatchingCount) {
        return matchingCount == expectedMatchingCount;
    }

    public long calculateTotalPrize(int winningCount) {
        return (long) prizeMoney * winningCount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
