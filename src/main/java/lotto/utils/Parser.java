package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String COMMA = ",";

    public static List<String> parseWithComma(String userInput) {
        return Arrays.stream(userInput.split(COMMA, -1))
                .toList();
    }
}