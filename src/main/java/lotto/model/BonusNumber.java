package lotto.model;

import static lotto.utils.Constants.END_LOTTO_NUMBER;
import static lotto.utils.Constants.INTEGER_RANGE;
import static lotto.utils.Constants.START_LOTTO_NUMBER;

public class BonusNumber {
    private final String ERROR_NOT_INTEGER = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    private final String ERROR_NOT_CORRECT_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
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
