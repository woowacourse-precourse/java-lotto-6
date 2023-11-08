package lotto.domain.rank;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {

    THREE_MATCHED(3, false, 5_000L),
    FOUR_MATCHED(4, false, 50_000L),
    FIVE_MATCHED(5, false, 1_500_000L),
    FIVE_MATCHED_WITH_BONUS(5, true, 30_000_000L),
    SIX_MATCHED(6, false, 2_000_000_000L);

    private final int matchedCount;
    private final boolean bonusMatched;
    private final long profit;

    Rank(final int matchedCount, final boolean bonusMatched, final long profit) {
        this.matchedCount = matchedCount;
        this.bonusMatched = bonusMatched;
        this.profit = profit;
    }

    public static Optional<Rank> of(final int matchedCount, final boolean bonusMatched) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matched(matchedCount, bonusMatched))
                .findFirst();
    }

    private boolean matched(final int matchedCount, final boolean bonusMatched) {
        return matchedCount == this.matchedCount && bonusMatched == this.bonusMatched;
    }

    public long getProfit() {
        return profit;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean getBonusMatched() {
        return bonusMatched;
    }
}
