package lotto.Validation;

import static lotto.Util.Util.ConvertStringToInteger;

import lotto.Exception.CommonValidationException;
import lotto.Message.ExceptionMessage.CommonValidationErrorMessage;
import lotto.Util.Util;

public class CommonValidation {

    public void isValidRange(Integer value) {
        if (value < 1 || value > 45) {
            throw new CommonValidationException(CommonValidationErrorMessage.RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    public void isBlank(String value) {
        if (value.contains(" ")) {
            throw new CommonValidationException(CommonValidationErrorMessage.BLANK_VALUE_ERROR_MESSAGE.getMessage());
        }
    }

    public void isInteger(String value) {
        try {
            ConvertStringToInteger(value);
        } catch (NumberFormatException e) {
            throw new CommonValidationException(CommonValidationErrorMessage.INTEGER_VALUE_ERROR_MESSAGE.getMessage());
        }
    }
}