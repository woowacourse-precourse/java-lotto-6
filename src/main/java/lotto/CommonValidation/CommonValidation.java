package lotto.CommonValidation;

import static lotto.Dictionary.LottoDictionary.*;
import static lotto.Message.ExceptionMessage.CommonValidationErrorMessage.*;
import static lotto.Util.Util.ConvertStringToInteger;

import lotto.Dictionary.LottoDictionary;
import lotto.Exception.CommonValidationException;

public class CommonValidation {


    public static void isValidLottoNumber(Integer value) {
        if (value < LOTTO_MIN_NUMBER.getValue() || value > LOTTO_MAX_NUMBER.getValue()) {
            throw new CommonValidationException(RANGE_ERROR_MESSAGE.getMessage(value));
        }
    }

    public static void hasBlank(String value) {
        if (value.contains(" ")) {
            throw new CommonValidationException(BLANK_VALUE_ERROR_MESSAGE.getMessage(value));
        }
    }

    public static void isInteger(String value) {
        try {
            ConvertStringToInteger(value);
        } catch (NumberFormatException e) {
            throw new CommonValidationException(INTEGER_VALUE_ERROR_MESSAGE.getMessage(value));
        }
    }
}