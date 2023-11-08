package lotto.vailator;

import static lotto.util.ErrorMessage.*;

public class InputValidator {
    private static final String numbersInputRegex = "([0-9]+,)+[0-9]+";
    private static final String BLANK = " ";

    private boolean isNotInteger(String number) {
        try {
            Integer.parseInt(number);
            return false;
        } catch (NumberFormatException ex) {
            return true;
        }
    }

    public void checkInteger(String number) {
        if (isNotInteger(number)) {
            throw new IllegalArgumentException(NOT_INTEGER.getErrorMessage());
        }
    }

    private boolean hasBlank(String numbers) {
        return numbers.contains(BLANK);
    }

    public void checkBlank(String numbers) {
        if (hasBlank(numbers)) {
            throw new IllegalArgumentException(BLANK_ERROR.getErrorMessage());
        }
    }

    private boolean hasNotOnlyNumberAndDelimiterComma(String numbers) {
        return !numbers.matches(numbersInputRegex);
    }

    public void checkOnlyNumberAndDelimiterCommaContain(String numbers) {
        if (hasNotOnlyNumberAndDelimiterComma(numbers)) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR.getErrorMessage());
        }
    }
}
