package lotto.view.console.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.AppException;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;
import lotto.validator.NumberValidator;
import lotto.validator.StringValidator;

public class InputUtil {
    private InputUtil() {
    }

    public static String readNonEmptyLineInput() {
        String input = Console.readLine();
        StringValidator.of(input).shouldNotEmpty(ErrorMessage.INPUT_IS_EMPTY);
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
        NumberValidator.of(input).shouldPositive(ErrorMessage.INPUT_NOT_POSITIVE_NUMBER);
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

    public static <T> T retryOnException(InputFunction<T> inputFunction, boolean lineBreak) {
        while (true) {
            try {
                return inputFunction.handleInput();
            } catch (AppException e) {
                System.out.println(e.getMessage());
                if (lineBreak) {
                    System.out.println();
                }
            }
        }
    }

    public static <T> T retryOnException(InputFunction<T> inputFunction) {
        return retryOnException(inputFunction, false);
    }

    @FunctionalInterface
    public interface InputFunction<T> {
        T handleInput() throws AppException;
    }
}
