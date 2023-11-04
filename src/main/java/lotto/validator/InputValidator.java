package lotto.validator;

import lotto.constants.InputPattern;
import lotto.exception.NotDivisionCommaException;
import lotto.exception.NotNumericException;

public class InputValidator {
    public void validateNumeric(String lottoPurchasePrice) {
        if (InputPattern.isNotNumeric(lottoPurchasePrice)) {
            throw new NotNumericException();
        }
    }

    public void validateDivisionComma(String winningNumbers) {
        if (InputPattern.isNotDivisionComma(winningNumbers)) {
            throw new NotDivisionCommaException();
        }
    }
}
