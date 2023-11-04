package lotto.utils.converter;

import java.util.Arrays;
import java.util.List;

public class Converter {

    private static final String COMMA = ",";

    private Converter() {
    }

    public static List<Integer> convertStringToList(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(Integer::parseInt)
                .toList();
    }
}
