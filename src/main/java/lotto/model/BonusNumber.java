package lotto.model;

public class BonusNumber {

    private static final String BONUS_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.";

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    // 이거 꼭 필요한지 생각해보기
    public boolean isEqualToBonus(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateNumberInRange(int bonusNumber) {
        if (isBonusNumberValid(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private boolean isBonusNumberValid(int bonusNumber) {
        return bonusNumber < LottoConstants.START_NUMBER || bonusNumber > LottoConstants.END_NUMBER;
    }
}
