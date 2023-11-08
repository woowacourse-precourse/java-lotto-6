package lotto.util;

import static lotto.constant.message.ErrorMessage.INT_FORMAT_ERROR;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    public static int stringToInt(String str) throws IllegalArgumentException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INT_FORMAT_ERROR);
        }
    }

    public static List<Integer> stringToList(String str) throws IllegalArgumentException {
        try {
            return Stream.of(str.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INT_FORMAT_ERROR);
        }
    }
}
