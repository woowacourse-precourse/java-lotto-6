package lotto.constant;

public enum BonusString {
    BONUS("Bonus"),
    NOBONUS("NoBonus");
    private final String bonus;

    BonusString(String hasBonus) {
        this.bonus = hasBonus;
    }

    public String getBonus() {
        return bonus;
    }
}
