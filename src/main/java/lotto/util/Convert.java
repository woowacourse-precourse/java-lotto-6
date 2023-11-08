package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Convert {

    public static List<Integer> convertToNumbers(String target) {
        List<Integer> numbers = new ArrayList<>();
        for (String winningNumber : target.split(",")) {
            ExceptionHandling.isValidNumber(winningNumber);
            numbers.add(Integer.parseInt(winningNumber));
        }
        return numbers;
    }

    public static int convertToNumber(String target) {
        ExceptionHandling.isValidNumber(target);
        return Integer.parseInt(target);
    }
}
