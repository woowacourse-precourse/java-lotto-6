package lotto.utils;

import static lotto.constants.ErrorConstants.ERROR_BLANK_INPUT;
import static lotto.constants.ErrorConstants.ERROR_LOTTO_NUMBER_FORMAT;
import static lotto.constants.ErrorConstants.ERROR_LOTTO_NUMBER_RANGE_OVER;
import static lotto.constants.ErrorConstants.ERROR_NON_NUMBER_TYPE_INPUT;
import static lotto.constants.ErrorConstants.ERROR_NULL_INPUT;

import lotto.exception.InputException;

public class InputValidator {

    private static final String LOTTO_NUMBER_REGEX = "^(?:[1-9]|[1-3][0-9]|4[0-5])(,(?:[1-9]|[1-3][0-9]|4[0-5])){5}$";
    private static final String LOTTO_RANGE_REGEX = "^(?:[1-9]|[1-3][0-9]|4[0-5])$";

    public static void nullCheck(String inputValue) {
        if (inputValue == null) {
            throw InputException.of(ERROR_NULL_INPUT);
        }
    }

    public static void blankCheck(String inputValue) {
        if (inputValue.isBlank()) {
            throw InputException.of(ERROR_BLANK_INPUT);
        }
    }

    public static void numberTypeCheck(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw InputException.of(ERROR_NON_NUMBER_TYPE_INPUT);
        }
    }

    public static void lottoFormatCheck(String inputValue) {
        if (!inputValue.matches(LOTTO_NUMBER_REGEX)) {
            throw InputException.of(ERROR_LOTTO_NUMBER_FORMAT);
        }
    }

    public static void lottoNumberRangeCheck(String inputValue) {
        if (!inputValue.matches(LOTTO_RANGE_REGEX)) {
            throw InputException.of(ERROR_LOTTO_NUMBER_RANGE_OVER);
        }
    }
}
