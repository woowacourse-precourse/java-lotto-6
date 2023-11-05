package lotto.constant;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    SIX(2_000_000_000L, 6),
    FIVE_WITH_BONUS(30_000_000L, 5),
    FIVE_WITHOUT_BONUS(1_500_000L, 5),
    FOUR(50_000L, 4),
    THREE(5_000L, 3),
    NO_PRIZE(0L, 0);

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

    public static boolean isWinningRank(LottoRank lottoRank) { return lottoRank != NO_PRIZE; }

    public static List<LottoRank> getWinningRanks() { return Arrays.stream(values()).filter(LottoRank::isWinningRank).toList(); }

    public static LottoRank getByBonusMatchWhenMatchCountIsFive(boolean isBonusMatched) {
        if (isBonusMatched) {
            return FIVE_WITH_BONUS;
        }

        return FIVE_WITHOUT_BONUS;
    }

    public static LottoRank getByMatchCountWhenBonusNotMatched(int matchCount) {
        List<LottoRank> ranks = List.of(values());

        return ranks.stream()
                .filter(value -> value.hasSameMatchCount(matchCount))
                .findAny()
                .orElse(NO_PRIZE);
    }
}
