package lotto.model;

public class BonusNumber {
    private int bonus;

    public BonusNumber(String bonus) {
        this.bonus = Integer.parseInt(bonus);
    }

    public int getNumber() {
        return bonus;
    }
}
