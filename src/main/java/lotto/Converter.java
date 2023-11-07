package lotto;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    private static final String NUMBER_DELIMITER = ",";
    private static final String NUMERIC_INPUT_REQUEST_MESSAGE = "숫자로 변환 가능한 값을 입력해 주십시오.";

    public static int convertToNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_INPUT_REQUEST_MESSAGE);
        }
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
