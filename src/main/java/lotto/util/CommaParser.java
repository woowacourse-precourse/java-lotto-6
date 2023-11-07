package lotto.util;

import java.util.List;

public class CommaParser {

    private static final String COMMA_REGEX = ",";

    public static List<String> parse(String input) {
        String[] splitsByComma = input.split(COMMA_REGEX);
        return List.of(splitsByComma);
    }
}