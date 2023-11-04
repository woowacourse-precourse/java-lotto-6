package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
    private static final String NULL_OR_EMPTY_ERROR_MESSAGE = "[ERROR] 공백이나 빈 값은 입력이 불가능합니다.";
    private static final String NOT_ALLOWED_CHARACTER_ERROR_MESSAGE = "[ERROR] 숫자만 입력이 가능합니다.";
    private static final Pattern WINNING_NUMBERS = Pattern.compile("^\\d+(,\\d+)*$");
    private static final String SPACE = " ";
    private static final String DELIMITER = ",";

    public static String getLine() {
        String input = read().trim();
        validateNullOrEmpty(input);

        return input;
    }

    public static List<Integer> getWinningNumbers() {
        String input = getLine();
        validateCharacter(input);

        return toInts(split(input));
    }

    private static String read() {
        return Console.readLine();
    }

    private static void validateNullOrEmpty(String input) {
        if (input == null || input.isBlank() || input.contains(SPACE)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }

    private static void validateCharacter(String input) {
        if (!WINNING_NUMBERS.matcher(input).matches()) {
            throw new IllegalArgumentException(NOT_ALLOWED_CHARACTER_ERROR_MESSAGE);
        }
    }

    private static String[] split(String input) {
        return input.split(DELIMITER);
    }

    private static List<Integer> toInts(String[] inputs) {
        return Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
}
