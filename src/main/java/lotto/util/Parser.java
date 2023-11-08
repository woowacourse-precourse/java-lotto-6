package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.exception.ParserExceptionMessages;
import lotto.view.OutputView;

public class Parser {

    public static Integer stringToInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            OutputView.println(ParserExceptionMessages.EXPECTED_INTEGER);
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> stringToIntegerListWithSplittingBySeparator(final String input,
                                                                            final String separator) {
        List<String> splittedInput = stringToStringListWithSplittingBySeparator(input, separator);
        return splittedInput.stream().map(Parser::stringToInteger).toList();
    }

    public static List<String> stringToStringListWithSplittingBySeparator(final String input, final String separator) {
        return Arrays.stream(input.split(separator))
                .map(String::trim)
                .toList();
    }
}