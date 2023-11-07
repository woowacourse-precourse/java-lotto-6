package lotto.domain;

import java.util.function.BiPredicate;

import static java.util.Arrays.*;

public enum WinningStatistics {
    THREE_MATCH(5_000, 3, (countMatch, bonusCheck) -> countMatch == 3),
    FOUR_MATCH(50_000, 4, (countMatch, bonusCheck) -> countMatch == 4),
    FIVE_MATCH(1_500_000, 5, (countMatch, bonusCheck) -> countMatch == 5 && !bonusCheck),
    FIVE_MATCH_AND_BONUS(30_000_000, 5, (countMatch, bonusCheck) -> countMatch == 5 && bonusCheck),
    SIX_MATCH(2_000_000_000, 6, (countMatch, bonusCheck) -> countMatch == 6),
    MISS_MATCH(0, 0, (countMatch, bonusCheck) -> countMatch < 3);

    private final int amount;
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> bonusCheck;

    WinningStatistics(final int amount, final int matchCount, final BiPredicate<Integer, Boolean> bonusCheck) {
        this.amount = amount;
        this.matchCount = matchCount;
        this.bonusCheck = bonusCheck;
    }

    public static WinningStatistics getWinningStatistics(final int matchCount, final boolean bonusNumberCheck) {
        return stream(WinningStatistics.values())
                .filter(winningStatistics -> winningStatistics.bonusCheck.test(matchCount,bonusNumberCheck))
                .findAny()
                .orElse(MISS_MATCH);
    }

    public int getAmount() {
        return amount;
    }

    public int getMatchCount() {
        return matchCount;
    }

}
