package lotto.model;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.stream.Stream;

public enum MatchingType {

    SIX(MatchCount.SIX, BonusStatus.NONE),
    FIVE_WITH_BONUS(MatchCount.FIVE, BonusStatus.INCLUDED),
    FIVE(MatchCount.FIVE, BonusStatus.NONE),
    FOUR(MatchCount.FOUR, BonusStatus.NONE),
    THREE(MatchCount.THREE, BonusStatus.NONE),
    NONE(MatchCount.NONE, BonusStatus.NONE);

    private static final Map<MatchCount, MatchingType> matchingTypes = Stream.of(values())
            .filter(type -> type.bonusStatus == BonusStatus.NONE)
            .collect(toMap(type -> type.matchCount, type -> type));

    private final MatchCount matchCount;

    private final BonusStatus bonusStatus;

    MatchingType(final MatchCount matchCount, final BonusStatus bonusStatus) {
        this.matchCount = matchCount;
        this.bonusStatus = bonusStatus;
    }

    public static MatchingType find(
            final MatchCount matchCount,
            final BonusStatus bonusStatus
    ) {
        final MatchingType matchingType
                = matchingTypes.getOrDefault(matchCount, MatchingType.NONE);

        if (matchingType == FIVE && bonusStatus == BonusStatus.INCLUDED) {
            return MatchingType.FIVE_WITH_BONUS;
        }
        return matchingType;
    }

    public int getCount() {
        return matchCount.getCount();
    }

    public boolean hasBonus() {
        return bonusStatus == BonusStatus.INCLUDED;
    }
}
