package lotto.util;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static List<String> splitByComma(String winnerNumber) {
        return Arrays.stream(StringUtils.removeSpace(winnerNumber).split(","))
                .toList();
    }

    public static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }
}
