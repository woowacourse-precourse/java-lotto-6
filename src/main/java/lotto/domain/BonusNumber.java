package lotto.domain;

public class BonusNumber {
    private final int bonus;

    public BonusNumber(String bonus) {
        this.bonus = Integer.parseInt(bonus);
    }

    public int getBonus() {
        return bonus;
    }
}
