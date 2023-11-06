package lotto.utils;

import java.util.Arrays;
import java.util.List;
import lotto.constants.ErrorMessage;

public class Converter {

    private Converter() {
    }

    public static <T> int convertToInt(T t) {
        try {
            return Integer.parseInt(String.valueOf(t));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT.getMessage());
        }
    }

    public static <T> List<Integer> convertToIntegerList(T[] t) {
        try {
            return Arrays.stream(t)
                    .map(String::valueOf)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_INPUT.getMessage());
        }
    }
}
