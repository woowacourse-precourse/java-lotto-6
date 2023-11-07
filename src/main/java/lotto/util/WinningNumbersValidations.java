package lotto.util;

import java.util.List;

public class WinningNumbersValidations {
    static int essentialCommaCount = LottoRules.LOTTO_NUMBER_COUNT.getValue() - 1;
    static int startNumber = LottoRules.START_NUMBER.getValue();
    static int endNumber = LottoRules.END_NUMBER.getValue();

    public static void IsContainEssentialComma(String winningNumbersBeforeSplit) {
        String winningNumbersremovedComma = winningNumbersBeforeSplit.replace(",", "");
        int essentialWinningNumbersCount = winningNumbersBeforeSplit.length() - essentialCommaCount;

        if (winningNumbersremovedComma.length() != essentialWinningNumbersCount) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkWinningNumbersUnique(List<Integer> winningNumbers) {
        List<Integer> distinctWinningNumbers = winningNumbers
                .stream()
                .distinct()
                .toList();

        if (distinctWinningNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkIsInRange(List<Integer> winningNumbers){
        for (int number : winningNumbers) {
            if (number < startNumber | number > endNumber) {
                throw new IllegalArgumentException();
            }
        }
    }

}
