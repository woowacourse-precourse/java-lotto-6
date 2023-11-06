package lotto.validator;

import lotto.constants.InputPattern;
import lotto.exception.NotDivisionCommaException;
import lotto.exception.NotNumericException;

public class InputValidator {
    public void validateNumeric(String purchasePrice) {
        if (InputPattern.isNotNumeric(purchasePrice)) {
            throw new NotNumericException();
        }
    }

    public void validateDivisionComma(String lotto) {
        if (InputPattern.isNotDivisionComma(lotto)) {
            throw new NotDivisionCommaException();
        }
    }
}
