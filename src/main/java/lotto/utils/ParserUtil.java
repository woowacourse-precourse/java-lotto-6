package lotto.utils;

import static lotto.contents.ContentStrings.SPLIT_COMMA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserUtil {

    public static int parseStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> parseStringToIntList(String input) {
        return Arrays.stream(input.split(SPLIT_COMMA.getValue()))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
