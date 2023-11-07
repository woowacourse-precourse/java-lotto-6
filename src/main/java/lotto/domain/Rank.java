package lotto.domain;

import lotto.constant.LottoConstraint;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    OUT_RANK(0, -1),
    THREE_MATCH(5000, 3),
    FOUR_MATCH(50000, 4),
    FIVE_MATCH(1500000, 5),
    FIVE_AND_BONUS_MATCH(30000000, 5),
    SIX_MATCH(2000000000, 6);

    private final int prizeMoney;
    private final int matchedCount;

    Rank(int prizeMoney, int matchedCount) {
        this.prizeMoney = prizeMoney;
        this.matchedCount = matchedCount;
    }

    private static final Map<Integer, Rank> matchedCountToRank
            = Stream.of(values())
                    .filter(rank -> !isDecidedByBonusNumber(rank.matchedCount))
                    .collect(Collectors.toUnmodifiableMap(Rank::getMatchedNumberCount, Function.identity()));
    
    public static Rank findByMatchedCountAndBonusNumberMatched(int matchedCount, boolean bonusNumberMatched) {
        if (isDecidedByBonusNumber(matchedCount)) {
            return decideByBonusNumberMatched(bonusNumberMatched);
        }
        return matchedCountToRank.getOrDefault(matchedCount, OUT_RANK);
    }

    private static boolean isDecidedByBonusNumber(int matchedCount) {
        return matchedCount == LottoConstraint.DECIDED_RANK_BY_BONUS_NUMBER.getValue();
    }

    private static Rank decideByBonusNumberMatched(boolean bonusNumberMatched) {
        if (bonusNumberMatched) {
            return FIVE_AND_BONUS_MATCH;
        }
        return FIVE_MATCH;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchedNumberCount() {
        return matchedCount;
    }
}