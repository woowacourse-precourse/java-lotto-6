package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.view.ErrorMessage;

public class StringUtil {

    public static void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL);
        }
    }

    public static void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.REQUIRED_VALUE);
        }
    }

    public static int checkNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER);
        }
    }

    public static void checkDelimiter(String input) {
        String regex = "[^0-9,]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT);
        }
    }

    public static List<Integer> splitAndToList(String input) {
        return Arrays.stream(input.split(","))
                .map((str) -> Integer.parseInt(str))
                .toList();
    }
}
