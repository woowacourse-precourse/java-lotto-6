package lotto.util.converter;

import java.util.Arrays;
import java.util.List;

public class ListConverter {
    public static <T> List<String> convertToStringList(List<T> input) {
        return input.stream()
                .map(String::valueOf)
                .toList();
    }

    public static List<String> splitStringByComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }
}
