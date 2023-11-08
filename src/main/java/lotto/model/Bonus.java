package lotto.model;

public enum Bonus {

    BONUS_INCLUDE(true),
    BONUS_EXCLUDE(false);

    private final boolean hasBonus;

    Bonus(final boolean hasBonus) {
        this.hasBonus = hasBonus;
    }

    public boolean isSame(final boolean value) {
        return this.getValue() == value;
    }

    public boolean getValue() {
        return hasBonus;
    }
}
