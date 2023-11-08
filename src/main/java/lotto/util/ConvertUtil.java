package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtil {
    private static final String DELIMITER = ",";
    public static String[] convertInputToLottoNumbers(String input) {
        return input.split(DELIMITER);
    }

    public static List<Integer> convertInputToIntegerLottoNumbers(String input) {
        String[] inputs = input.split(DELIMITER);
        return Arrays.stream(inputs).map(Integer::parseInt).collect(Collectors.toList());
    }
}
