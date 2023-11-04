package Model;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate1to45(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validate1to45(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }
}
