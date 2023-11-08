package lotto.validator;

import lotto.util.LottoRules;

import java.util.List;

public class valiator {
    private static int essentialCommaCount = LottoRules.LOTTO_NUMBER_COUNT.getValue() - 1;
    private static int startNumber = LottoRules.START_NUMBER.getValue();
    private static int endNumber = LottoRules.END_NUMBER.getValue();

    public static void IsContainEssentialComma(String winningNumbersBeforeSplit) {
        String winningNumbersremovedComma = winningNumbersBeforeSplit.replace(",", "");
        int essentialWinningNumbersCount = winningNumbersBeforeSplit.length() - essentialCommaCount;

        if (winningNumbersremovedComma.length() != essentialWinningNumbersCount) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateSplitedCommonNumbers(List<Integer> splitedCommonNumbers) {
        checkIsNumberUnique(splitedCommonNumbers);
        for (int number : splitedCommonNumbers) {
            checkIsInRange(number);
        }

    }

    public static void checkIsNumberUnique(List<Integer> winningNumbers) {
        List<Integer> distinctWinningNumbers = winningNumbers
                .stream()
                .distinct()
                .toList();

        if (distinctWinningNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkIsInRange(int number) {
        if (number < startNumber | number > endNumber) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkBonusNumberLength(String bonusNumberBeforeValidate) {
        if (bonusNumberBeforeValidate.length() > 2) {
            throw new IllegalArgumentException();
        }
    }
}
