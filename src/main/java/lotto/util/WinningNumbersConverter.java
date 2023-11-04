package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbersConverter {
    private static List<String> winningNumbersAsStringList;

    public static List<Integer> convertStringToList(String winningNumbersAsString) {
        winningNumbersAsStringList = List.of(winningNumbersAsString.split(","));
        WinningNumbersValidator.validateWinningNumbers(winningNumbersAsStringList);
        return convertStringListToIntegerList(winningNumbersAsStringList);
    }

    private static List<Integer> convertStringListToIntegerList(List<String> winningNumbersAsStringList) {
        List<Integer> numbers = new ArrayList<>();

        for (String numberAsString : winningNumbersAsStringList) {
            int number = Integer.parseInt(numberAsString);
            numbers.add(number);
        }

        return numbers;
    }
}
