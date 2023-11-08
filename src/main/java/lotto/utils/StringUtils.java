package lotto.utils;

import lotto.constant.ErrorMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {
    private static final String SPLIT_DELIMITER = ",";

    private StringUtils() {
    }

    public static int stringToInt(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }
    }

    public static List<String> splitString(String inputString) {
        return Arrays.stream(inputString.split(SPLIT_DELIMITER)).toList();
    }

    public static List<Integer> convertToIntegerList(List<String> stringList) {
        List<Integer> result = new ArrayList<>();
        stringList.forEach(s -> {
            result.add(StringUtils.stringToInt(s.trim()));
        });
        return result;
    }
}
