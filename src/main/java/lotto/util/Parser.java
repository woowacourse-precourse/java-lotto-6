package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static final String SEPARATOR = ",";

    public static int inputToNumber(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> inputToLottoNumbers(String inputLotto) {
        return Arrays.stream(inputLotto.split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
