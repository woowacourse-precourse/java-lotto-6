package lotto.validator;

import static lotto.constants.Message.BONUS_NUMBER_ERROR;
import static lotto.constants.Message.BONUS_DUPLICATED_ERROR;

import lotto.constants.Constants;

import java.util.List;

public class BonusNumberValidator {
    public int bonusNumber;
    private List<Integer> prizeNumbers;

    public BonusNumberValidator(List<Integer> prizeNumbers) {
        this.prizeNumbers = prizeNumbers;
    }

    public void validate(String number) {
        isNumber(number);
        isCorrectNumber();
        isDuplicated();
    }

    private void isNumber(String number) {
        try {
            this.bonusNumber = Integer.parseInt(number);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR.getErrorMessage());
        }
    }

    private void isCorrectNumber() {
        if (bonusNumber < Constants.MIN_NUMBER || bonusNumber > Constants.MAX_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR.getErrorMessage());
        }
    }

    private void isDuplicated() {
        if (prizeNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATED_ERROR.getErrorMessage());
        }
    }
}
