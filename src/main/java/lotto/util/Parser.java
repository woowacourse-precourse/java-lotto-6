package lotto.util;

import java.util.List;

import static lotto.exception.LottoException.INPUT_ONLY_NUMBER;

public class Parser {

    private static final String LIST_DELIMITER = ",";
    private static final String EMPTY = "";

    private Parser() {
    }

    public static List<Integer> stringToIntList(final String string) {
        validateNull(string);
        List<String> strings = List.of(string.split(LIST_DELIMITER));
        strings.forEach(Parser::validateInteger);
        return strings.stream()
                .map(Parser::stringToInt)
                .toList();
    }

    private static void validateNull(String string) {
        if (string == null) {
           INPUT_ONLY_NUMBER.create();
        }
    }

    private static void validateInteger(final String string) {
        if (isNotInteger(string) || isEmpty(string)) {
            INPUT_ONLY_NUMBER.create();
        }
    }

    private static boolean isNotInteger(final String string) {
        return !string.matches("^[\\d]*$");
    }

    private static boolean isEmpty(final String string) {
        return string.equals(EMPTY);
    }

    public static int stringToInt(final String string) {
        validateNull(string);
        validateInteger(string);
        return Integer.parseInt(string);
    }
}