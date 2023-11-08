package lotto.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum LottoRank {
    SIX(2_000_000_000L, 6, false),
    FIVE_WITH_BONUS(30_000_000L, 5, true),
    FIVE_WITHOUT_BONUS(1_500_000L, 5, false),
    FOUR(50_000L, 4, false),
    THREE(5_000L, 3, false),
    NO_PRIZE(0L, 0, false);

    private final long winnings;
    private final int matchCount;
    private final boolean isBonusMatched;

    LottoRank(long winnings, int matchCount, boolean isBonusMatched) {
        this.winnings = winnings;
        this.matchCount = matchCount;
        this.isBonusMatched = isBonusMatched;
    }

    public long getWinnings() {
        return winnings;
    }

    private boolean hasSameMatchCount(int matchCount) { return this.matchCount == matchCount; }

    private boolean isBonusMatched(boolean isBonusMatched) { return this.isBonusMatched == isBonusMatched; }

    public static boolean isWinningRank(LottoRank lottoRank) { return lottoRank != NO_PRIZE; }

    public static List<LottoRank> getWinningRanks() { return Arrays.stream(values()).filter(LottoRank::isWinningRank).toList(); }

    public static LottoRank getRankByMatches(int matchCount, boolean isBonusMatched) {
        return Stream.of(values())
                .filter(rank -> rank.isBonusMatched(isBonusMatched))
                .filter(rank -> rank.hasSameMatchCount(matchCount))
                .findAny()
                .orElse(NO_PRIZE);
    }
}
