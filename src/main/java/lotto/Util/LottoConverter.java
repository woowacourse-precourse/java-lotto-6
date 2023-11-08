package lotto.Util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoConverter {
    private static final String COMMA_SEPARATOR = ",";

    public static List<Integer> convertStringToNumbers(String input) {
        String[] numberStrings = input.split(COMMA_SEPARATOR);

        List<Integer> numbers = Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return numbers;
    }
}
