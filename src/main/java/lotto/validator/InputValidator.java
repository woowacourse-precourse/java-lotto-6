package lotto.validator;

import lotto.constants.InputPattern;
import lotto.exception.NotNumericException;

public class InputValidator {
    public void validateNumeric(String lottoPurchasePrice) {
        if (InputPattern.isNotNumeric(lottoPurchasePrice)) {
            throw new NotNumericException();
        }
    }
}
