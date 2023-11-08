package lotto.util;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

    private static final String ERROR = "[ERROR] 입력을 다시 확인해주세요.";

    private StringUtils() {

    }

    public static List<Integer> splitStringToLottoNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR);
        }
    }
}
