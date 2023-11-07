package lotto.model;

public class BonusNumber {
    private final String INTEGER_RANGE = "^[0-9]+$";
    private final String ERROR_NOT_INTEGER = "^[0-9]+$";
    private final String ERROR_NOT_CORRECT_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final int START_LOTTO_NUMBER = 1;
    private final int END_LOTTO_NUMBER = 45;
    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumber(String bonus) {
        isInteger(bonus);
        isCorrectRange(bonus);
    }

    private void isInteger(String bonus) {
        if (!bonus.matches(INTEGER_RANGE)) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    private void isCorrectRange(String bonus) {
        int bonusNumber = Integer.parseInt(bonus);

        if (bonusNumber < START_LOTTO_NUMBER || bonusNumber > END_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_NOT_CORRECT_RANGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
