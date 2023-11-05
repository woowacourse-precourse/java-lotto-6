package lotto.configuration;

import lotto.BonusNumber;

public enum BonusCount {
    PLUS_ONE(1),
    PLUS_ZERO(0);

    private final Integer weight;

    BonusCount(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }
}
