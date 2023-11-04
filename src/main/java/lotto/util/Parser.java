package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static final String LOTTO_SEPARATOR = ",";

    public static int inputToNumber(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> inputToLottoNumbers(String inputLotto) {
        // "," 로만 구분해서 List 화 하면 된다
        return Arrays.stream(inputLotto.split(LOTTO_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
