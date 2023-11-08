package lotto.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class Parser {
    private static final String DELIMITER = ",";
    private static final String PARSE_ERROR_MESSAGE = "파싱 중 문제가 발생했습니다.";

    protected Parser() {
    }

    public static int toInt(String input) {
        int result = 0;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PARSE_ERROR_MESSAGE, e);
        }
        return result;
    }

    public static List<String> toList(String input) {
        List<String> result = Collections.emptyList();
        try {
            result = Arrays.asList(input.split(DELIMITER));
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(PARSE_ERROR_MESSAGE, e);
        }
        return result;
    }
}
