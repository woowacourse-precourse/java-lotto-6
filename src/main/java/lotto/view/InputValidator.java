package lotto.view;

import lotto.exception.InvalidInputException;

import static lotto.utils.constants.InputConstants.INVALID_INPUT_MESSAGE;
import static lotto.utils.constants.InputConstants.NUMERIC;

public class InputValidator {
    public void validateInputMoney(String inputMoney) {
        if (!isNumeric(inputMoney)) {
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        }
    }

    private boolean isNumeric(String inputMoney) {
        return inputMoney.matches(NUMERIC);
    }

    public void validateBonusNumber(String bonusNumber) {
        if (!isNumeric(bonusNumber)) {
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        }
    }
}
