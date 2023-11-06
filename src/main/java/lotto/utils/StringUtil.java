package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    public static int stringToInt(String inputValue) {
        InputValidator.validateAmountNotNumber(inputValue);
        return Integer.parseInt(inputValue);
    }

    public static List<Integer> StringToList(String inputValue) {
        InputValidator.validateAnswerNumberIsNumber(inputValue);
        return parseAnswerNumberToIntegerList(inputValue);
    }

    private static List<Integer> parseAnswerNumberToIntegerList(String inputValue) {
        return Arrays.stream(inputValue.split(","))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }

    public static String doubleToString(double rateOfReturn) {
        return "총 수익률은 " + rateOfReturn + "%입니다.";
    }
}
