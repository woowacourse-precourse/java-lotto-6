package lotto;

public class Bonus {
    private final int bonusNumber;

    public Bonus(int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(ErrorException.OUT_OF_RANGE_NUMBER.getErrorDescription());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
