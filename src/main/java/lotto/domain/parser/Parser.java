package lotto.domain.parser;

import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.parser.constants.InputConstraint.DELIMITER;
import static lotto.domain.validator.InputValidator.validateEmpty;
import static lotto.exception.ErrorMessage.REQUEST_NOT_INTEGER;

public class Parser {
    private Parser() {
    }

    public static int parseStringToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw LottoException.of(REQUEST_NOT_INTEGER, exception);
        }
    }

    public static List<Integer> splitByDelimiter(final String input) {
        try {
            validateEmpty(input);
            
            return Arrays.stream(input.split(DELIMITER.getValue()))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException exception) {
            throw LottoException.of(REQUEST_NOT_INTEGER, exception);
        }
    }
}
