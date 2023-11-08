package lotto.domain;

import static lotto.constant.ErrorMessage.NO_DUPLICATION_ALLOWED;
import static lotto.constant.ErrorMessage.WRONG_NUMBER_RANGE;
import static lotto.constant.GameNumber.MAX_NUMBER;
import static lotto.constant.GameNumber.MIN_NUMBER;

public class Bonus {

    private final int bonusNumber;

    public Bonus(int bonusNumber, Lotto winLotto) {
        validateNumber(bonusNumber);
        validateDuplication(bonusNumber, winLotto);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER.getNumber() || bonusNumber > MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(WRONG_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplication(int bonusNumber, Lotto winLotto) {
        for (Integer winNumber : winLotto.getNumbers()) {
            if (bonusNumber == winNumber) {
                throw new IllegalArgumentException(NO_DUPLICATION_ALLOWED.getMessage());
            }
        }
    }
}
