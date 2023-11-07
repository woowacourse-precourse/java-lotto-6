package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    private StringUtils() {
    }

    public static int stringToInt(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<String> splitString(String inputString) {
        return Arrays.stream(inputString.split(",")).toList();
    }

    public static List<Integer> convertToIntegerList(List<String> stringList) {
        List<Integer> result = new ArrayList<>();
        for (String s : stringList) {
            result.add(StringUtils.stringToInt(s.trim()));
        }
        return result;
    }
}
