package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Util {
    private static final String SPACE = " ";
    private static final String NO_SPACE = "";
    private static final String COMMA = ",";

    public static String removeSpace(String input) {
        return input.replaceAll(SPACE, NO_SPACE);
    }

    public static List<String> splitByComma(String input) {
        return Arrays.asList(input.split(COMMA));
    }
}
