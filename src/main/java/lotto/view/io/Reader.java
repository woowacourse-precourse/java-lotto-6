package lotto.view.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.exception.LottoGameException;

public class Reader {

    public static int getOneNumber() {
        String input = Console.readLine();
        return parseInt(input);
    }

    public static List<Integer> getNumbersInPattern(
            Function<String, String> preprocessor,
            Pattern pattern,
            String delimiter) {

        String input = getStringInPattern(preprocessor, pattern);
        return Arrays.stream(input.split(delimiter))
                .map(Reader::parseInt)
                .toList();
    }

    public static String getStringInPattern(
            Function<String, String> preprocessor,
            Pattern pattern) {
        String input = Console.readLine();
        String afterProcessing = preprocessor.apply(input);
        validateAnswersFormat(afterProcessing, pattern);

        return afterProcessing;
    }

    public static void validateAnswersFormat(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw LottoGameException.WRONG_ANSWERS_FORMAT.makeException();
        }
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw LottoGameException.WRONG_NUMBER_FORMAT.makeException();
        }
    }
}
