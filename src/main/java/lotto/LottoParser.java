package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoParser {
    public static int readLineToNumber(String readLine) {
        int number;
        try {
            number = Integer.parseInt(readLine);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    LottoErrorMessageConstants.PURCHASE_PRICE_NOT_NUMBER_INPUT_ERROR_MESSAGE.getMessage()
            );
        }
        return number;
    }

    public static List<Integer> readLineToNumbers(String readLine) {
        List<Integer> numbers = new ArrayList<>();
        String[] readLineSplit;
        try {
            readLineSplit = readLine.split(LottoSeparatorConstant.LOTTO_INPUT_SEPARATOR.getConstant());
            for (String number : readLineSplit) {
                numbers.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    LottoErrorMessageConstants.WINNER_NUMBER_INVALID_INPUT_ERROR_MESSAGE.getMessage()
            );
        }
        return numbers;
    }
}
