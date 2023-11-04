package lotto.util;

import java.util.List;

public class StringUtil {

    static final String DELIMITER = ",";
    public static List<String> splitWithComma(String input) {
        return List.of(input.split(DELIMITER));
    }

    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
