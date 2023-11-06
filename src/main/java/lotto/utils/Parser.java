package lotto.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static final String COMMA = ",";
    public static final String COMMA_WITH_SPACES_REGEX = ",\\s+";

    public static Integer parseToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> parseToIntegers(String input) {
        String strings = removeSpacesBetweenCommas(input);
        List<String> numbers = List.of(strings.split(COMMA));
        return numbers.stream()
                .map(Parser::parseToInteger)
                .collect(Collectors.toList());
    }

    public static String removeSpacesBetweenCommas(String input) {
        return input.replaceAll(COMMA_WITH_SPACES_REGEX, COMMA);
    }
}
