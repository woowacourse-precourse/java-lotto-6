package lotto.model;

public class BonusNumber extends Number {
    private int bonusNumber;
    public BonusNumber(int bonusNumber) {
        checkRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
