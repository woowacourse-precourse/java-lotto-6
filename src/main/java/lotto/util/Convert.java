package lotto.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convert {

    private static final String NON_INTEGER_INPUT_ERROR_MESSAGE = "[ERROR] 숫자를 입력해야 하며, 공백을 허용하지 않습니다.";
    private static final String BLANK_OR_NON_INTEGER_INPUT_ERROR_MESSAGE = "[ERROR] 공백 혹은 숫자가 아닌 입력을 포함할 수 없습니다.";

    public static int stringToInteger(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_INPUT_ERROR_MESSAGE);
        }
    }

    public static List<Integer> stringToIntegerList(String inputValue) {
        try {
            return Arrays.stream(inputValue.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BLANK_OR_NON_INTEGER_INPUT_ERROR_MESSAGE);
        }
    }

    public static String formatDoubleWithCommaAndRound(double totalYield) {
        return new DecimalFormat("#,##0.0").format(totalYield);
    }
}
