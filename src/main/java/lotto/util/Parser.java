package lotto.util;

import lotto.exception.ParserExceptionMessages;
import lotto.view.OutputView;

public class Parser {

    public static int stringToInt(final String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            OutputView.println(ParserExceptionMessages.EXPECTED_INTEGER);
            throw new IllegalArgumentException();
        }
    }
}
