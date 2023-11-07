package lotto.model;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        checkValidateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    public int getBonusNumber() {
        return bonusNumber;
    }

    private void checkValidateRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
