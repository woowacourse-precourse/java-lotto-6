package lotto;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    private static final String NUMBER_DELIMITER = ",";

    public static int convertToNumeric(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> convertWinningNumber(String winningNumber) {
        String[] seperatedWinningNumber = winningNumber.split(NUMBER_DELIMITER);
        List<Integer> convertedWinningNumber = new ArrayList<>();

        for (String number : seperatedWinningNumber) {
            convertedWinningNumber.add(convertToNumeric(number));
        }

        return convertedWinningNumber;
    }
}
