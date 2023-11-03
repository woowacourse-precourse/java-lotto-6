package lotto.model;

public class BonusNumber {

    private static final int BONUS_NUMBER_RANGE_START = 1;
    private static final int BONUS_NUMBER_RANGE_END = 45;
    private static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1부터 45까지의 숫자여야 합니다.";

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber > BONUS_NUMBER_RANGE_END || bonusNumber < BONUS_NUMBER_RANGE_START) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }
}
