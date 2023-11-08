package lotto.validator;

import lotto.constants.pattern.InputPattern;
import lotto.exception.global.NotDivisionCommaException;
import lotto.exception.global.NotNumericException;

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
