package lotto;

import static lotto.enums.LottoErrorMessageConstants.INPUT_NOT_NUMBER_ERROR_MESSAGE;
import static lotto.enums.LottoSeparatorConstant.LOTTO_INPUT_SEPARATOR;

import java.util.ArrayList;
import java.util.List;

public class LottoParser {
    public static int readLineToNumber(String readLine) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(readLine);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INPUT_NOT_NUMBER_ERROR_MESSAGE.getMessage());
        }
        return number;
    }

    public static List<Integer> readLineToNumbers(String readLine) throws IllegalArgumentException {
        List<Integer> numbers = new ArrayList<>();
        String[] readLineSplit;
        try {
            readLineSplit = readLine.split(LOTTO_INPUT_SEPARATOR.getConstant());
            for (String number : readLineSplit) {
                numbers.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INPUT_NOT_NUMBER_ERROR_MESSAGE.getMessage());
        }
        return numbers;
    }

    public static String numberToText(int number) {
        return Integer.toString(number);
    }
}
