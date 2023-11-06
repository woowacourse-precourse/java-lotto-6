package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FOUR(4, false, 50000L),
    FIVE(3, false, 5000L),
    NONE(0, false, 0L);

    private Integer matchingNumberCount;
    private Boolean hasMatchingBonusNumber;
    private Long winningPrice;

    Rank(Integer matchingNumberCount, Boolean hasMatchingBonusNumber, Long winningPrice) {
        this.matchingNumberCount = matchingNumberCount;
        this.hasMatchingBonusNumber = hasMatchingBonusNumber;
        this.winningPrice = winningPrice;
    }

    public static Rank findRankBy(int matchingCount, Boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(r -> r.hasRank(matchingCount, hasBonus))
                .findFirst()
                .orElse(NONE);
    }

    public Long getWinningPrice() {
        return this.winningPrice;
    }

    private boolean hasRank(int matchingCount, Boolean hasBonus) {
        return this.matchingNumberCount == matchingCount && this.hasMatchingBonusNumber.equals(hasBonus);
    }

}
