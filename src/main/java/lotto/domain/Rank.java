package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(2000000000L, 6, 0),
    SECOND(30000000L, 5, 1),
    THIRD(1500000L, 5, 0),
    FOURTH(50000L, 4, 0),
    FIFTH(5000L, 3, 0),
    UNRANKED(0L, 0, 0);

    private Long price;
    private Integer criterion;
    private Integer bonusCount;

    Rank(Long price, Integer criterion, Integer bonusCount) {
        this.price = price;
        this.criterion = criterion;
        this.bonusCount = bonusCount;
    }

    public static Rank determineByMatchingCount(Integer criterion, Integer bonusCount) {
        return Arrays.stream(Rank.values())
            .filter(rank -> rank.equalsCriterion(criterion))
            .filter(rank -> rank.equalsBonusCount(bonusCount))
            .findAny()
            .orElse(UNRANKED);
    }

    private boolean equalsCriterion(Integer criterion) {
        return this.criterion.equals(criterion);
    }

    private boolean equalsBonusCount(Integer bonusCount) {
        return this.bonusCount.equals(bonusCount);
    }
}
