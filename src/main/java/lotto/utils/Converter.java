package lotto.utils;

import java.util.Arrays;
import java.util.List;
import lotto.constants.ErrorMessage;

public class Converter<T> {

    private Converter() {
    }

    public static <T> int convertToInt(T t) {
        try {
            return Integer.parseInt(String.valueOf(t));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT.getMessage());
        }
    }

    public static <T> List<Integer> convertToIntegerListWithDelimiter(T t, String delimiter) {
        try {
            return Arrays.stream(String.valueOf(t).split(delimiter))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT.getMessage());
        }
    }
}
