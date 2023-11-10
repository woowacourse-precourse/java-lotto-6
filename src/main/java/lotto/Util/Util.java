package lotto.Util;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static int inputNumberToInteger(String payment) {
        try {
            return Integer.parseInt(payment);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<String> splitNumbersByComma(String numbersForSplit) {
        return List.of(numbersForSplit.split(","));
    }

    public static List<Integer> lottoToInteger(List<String> splitLotto) {
        List<Integer> integerWinningNumbers = new ArrayList<>();

        for (String number : splitLotto) {
            try {
                integerWinningNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return integerWinningNumbers;
    }
}
