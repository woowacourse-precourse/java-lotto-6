package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {
    private static final String DELIMITER = ",";

    public static int convertStringToInt(String input) {
        InputValidator.validateInput(input);

        return Integer.valueOf(input);
    }

    public static List<Integer> convertToList(String input) {
        try {
            InputValidator.validateNotSurroundedByDelimiters(input);
            return Arrays.stream(input.trim().split(DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_MESSAGE.getErrorMessage());
        }
    }
}
