package lotto.model;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static BonusNumber inputBonusNumber(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }
}
