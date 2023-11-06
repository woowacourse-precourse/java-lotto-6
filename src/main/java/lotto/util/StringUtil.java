package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtil {
    public static Integer convertToInteger(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<String> tokenizeWithDelimiter(String input, String delimiter) {
        if (input == null || delimiter == null) {
            throw new IllegalArgumentException();
        }

        List<String> tokenizedInputs = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, delimiter);
        while (stringTokenizer.hasMoreTokens()) {
            tokenizedInputs.add(stringTokenizer.nextToken());
        }
        return tokenizedInputs;
    }
}
