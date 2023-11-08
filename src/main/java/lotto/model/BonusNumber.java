package lotto.model;

public class BonusNumber {

    private static final String BONUS_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.";

    private final int bonusNumber;

    public BonusNumber(final int bonusNumber) {
        validateNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateNumberInRange(final int bonusNumber) {
        if (isNotValidBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNotValidBonusNumber(final int bonusNumber) {
        return bonusNumber < LottoConstants.START_NUMBER || bonusNumber > LottoConstants.END_NUMBER;
    }
}
