package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(2000000000L, 6, false),
    SECOND(30000000L, 5, true),
    THIRD(1500000L, 5, false),
    FOURTH(50000L, 4, false),
    FIFTH(5000L, 3, false),
    UNRANKED(0L, 0, false);

    private Long price;
    private Integer criterion;
    private boolean requireBonus;

    Rank(Long price, Integer criterion, boolean requireBonus) {
        this.price = price;
        this.criterion = criterion;
        this.requireBonus = requireBonus;
    }

    public static Rank determineByMatchingCount(Integer criterion, boolean requireBonus) {
        return Arrays.stream(Rank.values())
            .filter(rank -> rank.equalsCriterion(criterion))
            .filter(rank -> rank.checkBonusRequiring(requireBonus))
            .findAny()
            .orElse(UNRANKED);
    }

    private boolean equalsCriterion(Integer criterion) {
        return this.criterion.equals(criterion);
    }

    private boolean checkBonusRequiring(boolean requireBonus) {
        return this.requireBonus == requireBonus;
    }
}
