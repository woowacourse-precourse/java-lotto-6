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

    public void validateAlreadyExist(Lotto lotto) {
        for (int i = 0; i < lotto.getSize(); i++) {
            if (bonusNumber == lotto.getItem(i)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
