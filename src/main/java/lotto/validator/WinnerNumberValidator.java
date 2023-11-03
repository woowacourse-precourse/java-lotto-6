package lotto.validator;

import lotto.message.ExceptionMessage;
import lotto.util.LottoUtil;

public class WinnerNumberValidator {

    public static void validate(String inputNumbers) {
        validateDividedByComma(inputNumbers);
        validateNaturalNumber(inputNumbers);
    }

    private static void validateDividedByComma(String inputNumbers) {
        if (!inputNumbers.contains(",")) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVIDED_BY_COMMA.getMessage());
        }
    }

    private static void validateNaturalNumber(String inputNumbers) {
        try {
            LottoUtil.convert(inputNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

}
