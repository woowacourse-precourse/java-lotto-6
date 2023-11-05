package lotto.model;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String NUMBER_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 숫자는 1에서 45 사이어야 합니다.";
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        checkNumberRange(bonusNumber);
    }

    private void checkNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
    
}
