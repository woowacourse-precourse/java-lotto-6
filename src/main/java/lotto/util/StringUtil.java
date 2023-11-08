package lotto.util;

import static lotto.constant.Constant.DELIMITER;
import static lotto.constant.Constant.DELIMITER_WITH_SPACE;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static List<String> splitWithComma(String input) {
        return List.of(input.split(DELIMITER));
    }

    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static String convertListToString(List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(DELIMITER_WITH_SPACE));
    }
}
