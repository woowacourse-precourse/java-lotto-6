package lotto.model;

public class BonusNumber extends Number {
    private final int bonusNumber;
    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
