package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static Long convertStringToLong(String stringMoney) throws NumberFormatException {
        return Long.parseLong(stringMoney);
    }

    public static List<Integer> convertStringToList(String winningNumber) throws NumberFormatException {
        return Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int convertStringToInt(String bonusNumber) throws NumberFormatException{
        return Integer.parseInt(bonusNumber);
    }
}
