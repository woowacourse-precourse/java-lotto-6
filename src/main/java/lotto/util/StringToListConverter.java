package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToListConverter {
    public static final String COMMA = ",";

    public static List<Integer> convert(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
