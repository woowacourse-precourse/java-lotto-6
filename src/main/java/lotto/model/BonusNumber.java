package lotto.model;

public class BonusNumber {
    private static final int BONUS_MIN_NUMBER = 1;
    private static final int BONUS_MAX_NUMBER = 45;
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validate(int bonusNumber) {

    }

}