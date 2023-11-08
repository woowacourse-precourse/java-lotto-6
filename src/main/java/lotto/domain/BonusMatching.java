package lotto.domain;

import java.util.function.UnaryOperator;

public class BonusMatching {

    private final Boolean status;

    private BonusMatching(final Boolean status) {
        this.status = status;
    }

    public static BonusMatching from(final Boolean status) {
        return new BonusMatching(status);
    }

    public boolean isBonusMatching(final UnaryOperator<Boolean> matchingBonus) {
        return matchingBonus.apply(status);
    }
}
