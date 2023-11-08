package lotto.utils;

import lotto.enums.ErrorMessages;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    private static final String SEPARATOR = ",";
    public static int stringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ErrorMessages.NON_NUMERIC_INPUT_MESSAGE.getMessage());
        }
    }

    public static List<Integer> stringToList(String string) {
        try {
            return Arrays.stream(string.split(SEPARATOR)).map(s -> stringToInt(s.trim())).toList();
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ErrorMessages.NON_NUMERIC_INPUT_MESSAGE.getMessage());
        }
    }
}
