package lotto.utils;

import static lotto.contents.ContentStrings.SPLIT_COMMA;

import java.util.Arrays;
import java.util.List;

public class ParserUtil {
    public static int parseLottoNumber(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(SPLIT_COMMA.getValue()))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
