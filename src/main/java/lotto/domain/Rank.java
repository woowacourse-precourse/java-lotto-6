package lotto.domain;

import java.util.Arrays;

public enum Rank {
    UNRANKED(0L, 0, false),
    FIFTH(5000L, 3, false),
    FOURTH(50000L, 4, false),
    THIRD(1500000L, 5, false),
    SECOND(30000000L, 5, true),
    FIRST(2000000000L, 6, false);

    private Long price;
    private Integer criterion;
    private boolean requireBonus;

    Rank(Long price, Integer criterion, boolean requireBonus) {
        this.price = price;
        this.criterion = criterion;
        this.requireBonus = requireBonus;
    }

    public static Rank determineByMatchingCount(Integer criterion, boolean requireBonus) {
        if(criterion.equals(SECOND.criterion) && requireBonus == SECOND.requireBonus) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
            .filter(rank -> rank.equalsCriterion(criterion))
            .findAny()
            .orElse(UNRANKED);
    }

    private boolean equalsCriterion(Integer criterion) {
        return this.criterion.equals(criterion);
    }

    public Integer getCriterion() {
        return criterion;
    }

    public Long getPrice() {
        return price;
    }

    public boolean requireBonusNumber() {
        return requireBonus;
    }
}
