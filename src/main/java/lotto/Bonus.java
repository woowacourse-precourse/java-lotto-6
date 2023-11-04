package lotto;


public class Bonus {

    private final int bonusNumber;

    public Bonus(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
    }

    private void validateBonusNumberRange(int bonusNumber) {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 45;

        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

}
