package lotto.model;

import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum MatchingType {

    SIX(MatchCount.SIX, BonusStatus.NONE),
    FIVE_WITH_BONUS(MatchCount.FIVE, BonusStatus.INCLUDED),
    FIVE(MatchCount.FIVE, BonusStatus.NONE),
    FOUR(MatchCount.FOUR, BonusStatus.NONE),
    THREE(MatchCount.THREE, BonusStatus.NONE),
    NONE(MatchCount.NONE, BonusStatus.NONE);

    private static final Map<BonusStatus, List<MatchingType>> matchingTypesByBonus
            = Arrays.stream(values()).collect(groupingBy(type -> type.bonusStatus));

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
        final List<MatchingType> matchingTypes = matchingTypesByBonus.get(bonusStatus);

        return matchingTypes.stream()
                .filter(matchingType -> matchingType.matchCount == matchCount)
                .findAny()
                .orElse(MatchingType.NONE);
    }
}
