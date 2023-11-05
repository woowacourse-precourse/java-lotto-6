package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOUR(4, false),
    FIVE(3, false),
    NONE(0, false);

    private Integer matchingNumberCount;
    private Boolean hasMatchingBonusNumber;

    Rank(Integer matchingNumberCount, Boolean hasMatchingBonusNumber) {
        this.matchingNumberCount = matchingNumberCount;
        this.hasMatchingBonusNumber = hasMatchingBonusNumber;
    }

    public static Rank findRankBy(int matchingCount, Boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(r -> r.hasRank(matchingCount, hasBonus))
                .findFirst()
                .orElse(NONE);
    }

    private boolean hasRank(int matchingCount, Boolean hasBonus) {
        return this.matchingNumberCount == matchingCount && this.hasMatchingBonusNumber.equals(hasBonus);
    }

}
