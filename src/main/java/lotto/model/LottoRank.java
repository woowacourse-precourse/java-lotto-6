package lotto.model;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Map;

public enum LottoRank {

    FIRST(MatchingType.SIX, LottoPrize.FIRST),
    SECOND(MatchingType.FIVE_WITH_BONUS, LottoPrize.SECOND),
    THIRD(MatchingType.FIVE, LottoPrize.THIRD),
    FOURTH(MatchingType.FOUR, LottoPrize.FOURTH),
    FIFTH(MatchingType.THREE, LottoPrize.FIFTH),
    NONE(MatchingType.NONE, LottoPrize.NONE);

    private static final Map<MatchingType, LottoRank> ranks = Arrays.stream(values())
            .collect(toMap(
                    rank -> rank.matchingType,
                    rank -> rank
            ));

    private final MatchingType matchingType;

    private final LottoPrize lottoPrize;

    LottoRank(final MatchingType matchingType, final LottoPrize lottoPrize) {
        this.matchingType = matchingType;
        this.lottoPrize = lottoPrize;
    }

    public static LottoRank of(final MatchingType matchingType) {
        return ranks.getOrDefault(matchingType, LottoRank.NONE);
    }
}
