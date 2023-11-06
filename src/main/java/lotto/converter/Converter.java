package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Converter {
    private static final String DELIMITER = ",";

    public static List<Integer> toIntegerList(String source) {
        return Arrays.stream(source.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
