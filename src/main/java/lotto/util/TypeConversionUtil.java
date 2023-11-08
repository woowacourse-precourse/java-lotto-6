package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TypeConversionUtil {

    private static final String COMMA_SPLIT = ",";

    public static int StringToInt(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }

    public static List<Integer> StringToIntegerList(String inputWinningNumber) {
        List<String> strWinningNumber = Stream.of(inputWinningNumber.split(COMMA_SPLIT))
                .toList();

        return strWinningNumber.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
