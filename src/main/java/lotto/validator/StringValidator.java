package lotto.validator;

import lotto.constant.Message.ErrorMessage;

public class StringValidator {

    public void isNotNullValidate(String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_MESSAGE.getErrorMessage());
        }
    }

    public void hasNotBlankValidate(String inputvalue) {
        if (inputvalue.replace(" ", "").length() != inputvalue.length()) {
            throw new IllegalArgumentException(ErrorMessage.HAS_BLANK_MESSAGE.getErrorMessage());
        }
    }
}