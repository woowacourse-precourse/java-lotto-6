package lotto.utils;

import static lotto.utils.Constants.DELIMETER;

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
        return Arrays.stream(winningNumber.split(DELIMETER))
                .map(String::trim) // to remove any leading or trailing spaces
                .map(Util::convertToInt) // assuming convertToInt is a static method in Util
                .collect(Collectors.toList());
    }
}
