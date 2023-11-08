package lotto.util;

import java.util.Arrays;
import java.util.List;

public class InputFormatter {

    public static List<Integer> formatWinningNumber(String input) {
        return Arrays.stream(input.split(Constants.COMMA.getValue()))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
