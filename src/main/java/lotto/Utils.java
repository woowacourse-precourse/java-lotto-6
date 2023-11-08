package lotto;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<Integer> convertStringToIntegerList(String source, String delimiter) {
        return convertListStringToListInteger(splitStringAsList(source, delimiter));
    }

    private static List<String> splitStringAsList(String source, String delimiter) {
        return Arrays.asList(source.split(delimiter));
    }

    private static List<Integer> convertListStringToListInteger(List<String> source) {
        return source.stream()
                .peek(TypeValidator::validateNumber)
                .map(Integer::parseInt)
                .toList();
    }
}
