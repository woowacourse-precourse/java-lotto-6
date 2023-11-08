package lotto.util;

import java.util.List;

import static lotto.exception.LottoException.INPUT_ONLY_NUMBER;

public class Parser {

    private static final String LIST_DELIMITER = ",";
    private static final String EMPTY = "";

    private Parser() {
    }

    public static List<Integer> stringToIntList(final String input) {
        validateNull(input);
        List<String> inputs = List.of(input.split(LIST_DELIMITER));
        inputs.forEach(Parser::validateInteger);
        return inputs.stream()
                .map(Parser::stringToInt)
                .toList();
    }

    private static void validateNull(String input) {
        if (input == null) {
            INPUT_ONLY_NUMBER.create();
        }
    }

    private static void validateInteger(final String input) {
        if (isNotInteger(input) || isEmpty(input)) {
            INPUT_ONLY_NUMBER.create();
        }
    }

    private static boolean isNotInteger(final String input) {
        return !input.matches("^[\\d]*$");
    }

    private static boolean isEmpty(final String input) {
        return input.equals(EMPTY);
    }

    public static int stringToInt(final String input) {
        validateNull(input);
        validateInteger(input);
        return Integer.parseInt(input);
    }
}
