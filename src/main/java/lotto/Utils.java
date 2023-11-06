package lotto;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<String> splitStringToList(String source, String delimiter) {
        return Arrays.asList(source.split(delimiter));
    }

    public static List<Integer> convertListStringToListInteger(List<String> source) {
        return source.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
