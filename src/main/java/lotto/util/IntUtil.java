package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;

public class IntUtil {
    public static List<Integer> makeIntegerNumbers(String[] splitNumbers) {
        List<Integer> integerNumbers = new ArrayList<>();
        for (String number : splitNumbers) {
            integerNumbers.add(makeUsableNumber(number));
        }
        return integerNumbers;
    }

    public static String[] splitNumbers(String numbers) {
        return numbers.split(",");
    }

    public static int makeUsableNumber(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.
                    NOT_INT_ERROR_MESSAGE.getErrorMessage());
        }
        return number;
    }
}
