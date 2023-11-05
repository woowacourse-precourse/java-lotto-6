package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbersConverter {
    private static List<String> winningNumbers;

    public static List<Integer> convertStringToList(String winningNumbersAsText) {
        winningNumbers = List.of(winningNumbersAsText.split(","));
        WinningNumbersValidator.validateWinningNumbers(winningNumbers);
        return convertStringListToIntegerList(winningNumbers);
    }

    private static List<Integer> convertStringListToIntegerList(List<String> winningNumbersAsTexts) {
        List<Integer> numbers = new ArrayList<>();

        for (String numberAsText : winningNumbersAsTexts) {
            int number = Integer.parseInt(numberAsText);
            numbers.add(number);
        }

        return numbers;
    }
}
