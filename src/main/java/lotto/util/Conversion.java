package lotto.util;

import static lotto.util.message.Error.MUST_INTEGER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Conversion {

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(MUST_INTEGER.getError());
        }
    }

    public static List<Integer> stringToList(String input) throws IllegalArgumentException {
        String[] stringArray = input.split(",");

        return Arrays.stream(stringArray)
                .map(String::trim)
                .map(Conversion::stringToInt)
                .collect(Collectors.toList());
    }
}
