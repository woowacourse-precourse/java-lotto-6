package lotto.enums;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoRank {

    FIFTH(3, false, 5_000L, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50_000L, "4개 일치 (50,000원)"),
    THIRD(5, false, 1_500_000L, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2_000_000_000L, "6개 일치 (2,000,000,000원)");

    private final int winningCount;
    private final boolean bonusMatch;
    private final long prizeAmount;
    private final String RankDescription;

    LottoRank(int winningCount, boolean bonusMatch, long prizeAmount, String RankDescription) {
        this.winningCount = winningCount;
        this.bonusMatch = bonusMatch;
        this.prizeAmount = prizeAmount;
        this.RankDescription = RankDescription;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public String getRankDescription() {
        return RankDescription;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public static LottoRank determineRank(int winningCount, boolean bonusMatch) {
        return Arrays.stream(LottoRank.values())
            .filter(rank -> rank.getWinningCount() == winningCount)
            .filter(rank -> rank.isBonusMatch() == bonusMatch || !rank.isBonusMatch())
            .findAny()
            .orElse(null);
    }
}