package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    private StringUtils() {
    }

    public static List<String> splitCommaToListString(String str) {
        return Arrays.stream(str.split(","))
                .collect(Collectors.toList());
    }

    public static List<Integer> convertStringListToIntegerList(List<String> strings) {
        return strings.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
}
