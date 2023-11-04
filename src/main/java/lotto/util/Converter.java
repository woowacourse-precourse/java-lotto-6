package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    private static final String SEPARATOR = ",";

    public static List<String> convertCommaSeparatedStringToList(final String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(String::trim)
                .toList();
    }
}
