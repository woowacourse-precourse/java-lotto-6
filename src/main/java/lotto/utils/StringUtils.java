package lotto.utils;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance();

    public static List<Integer> stringToNumbers(String numbers) {
        try {
            return Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 입력해야 합니다.");
        }
    }

    public static int stringToNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 입력해야 합니다.");
        }
    }

    public static String numbersToString(int number) {
        return numberFormat.format(number);
    }
}
