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
