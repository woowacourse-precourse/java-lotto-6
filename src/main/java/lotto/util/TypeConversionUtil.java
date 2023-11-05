package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConversionUtil {

    private static final String COMMA_SPLIT = ",";
    public static int StringToInt(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }
    
    public static List<Integer> StringToIntegerList(String inputWinningNumber) {
        List<String> strWinningNumber = Arrays.asList(inputWinningNumber.split(COMMA_SPLIT));

        return strWinningNumber.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
