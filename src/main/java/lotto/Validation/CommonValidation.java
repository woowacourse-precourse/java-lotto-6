package lotto.Validation;

import static lotto.Message.ExceptionMessage.CommonValidationErrorMessage.*;
import static lotto.Util.Util.ConvertStringToInteger;

import lotto.Exception.CommonValidationException;
import lotto.Message.ExceptionMessage.CommonValidationErrorMessage;
import lotto.Util.Util;

public class CommonValidation {

    public void isValidRange(Integer value) {
        if (value < 1 || value > 45) {
            throw new CommonValidationException(RANGE_ERROR_MESSAGE.getMessage(value));
        }
    }

    public void isBlank(String value) {
        if (value.contains(" ")) {
            throw new CommonValidationException(BLANK_VALUE_ERROR_MESSAGE.getMessage(value));
        }
    }

    public void isInteger(String value) {
        try {
            ConvertStringToInteger(value);
        } catch (NumberFormatException e) {
            throw new CommonValidationException(INTEGER_VALUE_ERROR_MESSAGE.getMessage(value));
        }
    }
}