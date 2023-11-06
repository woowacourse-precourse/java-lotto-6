package lotto.utils;

import static lotto.utils.Constants.DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.ExceptionMessage;

public class Util {
    public static int convertToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            ExceptionMessage.numberFormatException();
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> numberList(String winningNumber) {
        return Arrays.stream(winningNumber.split(DELIMITER))
                .map(String::trim)
                .map(Util::convertToInt)
                .collect(Collectors.toList());
    }
}
