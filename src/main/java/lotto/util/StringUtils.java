package lotto.util;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

    private StringUtils() {

    }

    public static List<Integer> splitStringToLottoNumbers(String input) {
        return Arrays.stream(input.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .toList();
    }
}
