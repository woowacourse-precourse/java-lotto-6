package lotto.view.console.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;

public class InputUtil {
    private InputUtil() {
    }

    public static String readNonEmptyLineInput() {
        String input = Console.readLine();
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException(ErrorMessage.INPUT_IS_EMPTY);
        }
        return input;
    }

    public static int readInt() {
        try {
            String input = readNonEmptyLineInput();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(ErrorMessage.INPUT_NOT_A_NUMBER);
        }
    }

    public static int readNaturalInt() {
        int input = readInt();
        if (input < 1) {
            throw new InvalidInputException(ErrorMessage.INPUT_NOT_POSITIVE_NUMBER);
        }
        return input;
    }

    public static List<Integer> parseInputToIntegers(String input, String regex) {
        // -1을 넣을 경우 빈 문자열도 포함해서 split한다. ex) "1,2,," -> ["1", "2", "", ""]
        String[] parts = input.split(regex, -1);
        return Arrays.stream(parts)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
