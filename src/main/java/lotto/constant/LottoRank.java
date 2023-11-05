package lotto.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum LottoRank {
    SIX(2_000_000_000L, 6),
    FIVE_WITH_BONUS(30_000_000L, 5),
    FIVE_WITHOUT_BONUS(1_500_000L, 5),
    FOUR(50_000L, 4),
    THREE(5_000L, 3),
    NO_PRIZE(0L, 0);

    private static final int MATCH_COUNT_FIVE = 5;

    private final long winnings;
    private final int matchCount;

    LottoRank(long winnings, int matchCount) {
        this.winnings = winnings;
        this.matchCount = matchCount;
    }

    public long getWinnings() {
        return winnings;
    }

    private boolean hasSameMatchCount(int matchCount) { return this.matchCount == matchCount; }

    private static boolean hasFiveMatchCount(int matchCount) { return MATCH_COUNT_FIVE == matchCount; }

    public static boolean isWinningRank(LottoRank lottoRank) { return lottoRank != NO_PRIZE; }

    public static List<LottoRank> getWinningRanks() { return Arrays.stream(values()).filter(LottoRank::isWinningRank).toList(); }

    private static LottoRank getByBonusMatchWhenMatchCountIsFive(boolean isBonusMatched) {
        if (isBonusMatched) {
            return FIVE_WITH_BONUS;
        }

        return FIVE_WITHOUT_BONUS;
    }

    public static LottoRank getRankByMatches(int matchCount, boolean isBonusMatched) {
        if (hasFiveMatchCount(matchCount)) {
            return getByBonusMatchWhenMatchCountIsFive(isBonusMatched);
        }

        return Stream.of(values())
                .filter(value -> value.hasSameMatchCount(matchCount))
                .findAny()
                .orElse(NO_PRIZE);
    }
}
