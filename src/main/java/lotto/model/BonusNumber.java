package lotto.model;

public class BonusNumber {

    private final int BonusNumber;

    public BonusNumber(int BonusNumber) {
        this.BonusNumber = BonusNumber;
    }

    public int getBonusNumber() {
        return BonusNumber;
    }

    public static BonusNumber inputBonusNumber(int BonusNumber) {
        return new BonusNumber(BonusNumber);
    }
}
