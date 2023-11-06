package domain;

public class BonusNumber {
    private static BonusNumber instance;
    private int bonusNumber;

    private BonusNumber() {}

    public static BonusNumber getInstance() {
        if (instance == null) {
            instance = new BonusNumber();
        }
        return instance;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
