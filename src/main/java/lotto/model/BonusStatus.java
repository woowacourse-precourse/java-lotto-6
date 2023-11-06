package lotto.model;

public enum BonusStatus {

    INCLUDED(true),
    NONE(false);

    private final boolean bonusContains;

    BonusStatus(final boolean bonusContains) {
        this.bonusContains = bonusContains;
    }
}
