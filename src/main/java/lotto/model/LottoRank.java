package lotto.model;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Map;

public enum LottoRank {

    FIRST(MatchCount.SIX, false, LottoPrize.FIRST),
    SECOND(MatchCount.FIVE, true, LottoPrize.SECOND),
    THIRD(MatchCount.FIVE, false, LottoPrize.THIRD),
    FOURTH(MatchCount.FOUR, false, LottoPrize.FOURTH),
    FIFTH(MatchCount.THREE, false, LottoPrize.FIFTH),
    NONE(MatchCount.NONE, false, LottoPrize.NONE);

    private static final Map<MatchCount, LottoRank> ranks = Arrays.stream(values())
            .filter(rank -> !rank.bonusMatches)
            .collect(toMap(
                    rank -> rank.matchCount,
                    rank -> rank
            ));

    private final MatchCount matchCount;

    private final boolean bonusMatches;

    private final LottoPrize lottoPrize;

    LottoRank(
            final MatchCount matchCount,
            final boolean bonusMatches,
            final LottoPrize lottoPrize
    ) {
        this.matchCount = matchCount;
        this.bonusMatches = bonusMatches;
        this.lottoPrize = lottoPrize;
    }

    public static LottoRank of(final MatchCount matchCount, final boolean bonusMatches) {
        if (bonusMatches && matchCount == MatchCount.FIVE) {
            return LottoRank.SECOND;
        }
        return ranks.getOrDefault(matchCount, LottoRank.NONE);
    }

    public long getPrize() {
        return lottoPrize.getAmount();
    }

    public int getNumberOfMatches() {
        return matchCount.getCount();
    }

    public boolean bonusMatches() {
        return bonusMatches;
    }
}
