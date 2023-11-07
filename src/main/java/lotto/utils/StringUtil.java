package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    private static final String LOTTO_NUMBER_SEPARATOR = ",";

    public static int stringToInt(String inputValue) {
        InputValidator.validateAmountNotNumber(inputValue);
        return Integer.parseInt(inputValue);
    }

    public static List<Integer> StringToList(String inputValue) {
        InputValidator.validateAnswerNumberIsNumber(inputValue);
        return parseAnswerNumberToIntegerList(inputValue);
    }

    private static List<Integer> parseAnswerNumberToIntegerList(String inputValue) {
        return Arrays.stream(inputValue.split(LOTTO_NUMBER_SEPARATOR))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }

    public static String formatRateOfReturn(double rateOfReturn) {
        return "총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.";
    }
}
