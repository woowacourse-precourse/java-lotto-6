package lotto.utils;

import static lotto.domain.LottoAttribute.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static void validateBudgetInput(String input) {
        if (!isPositiveNonZeroInteger(input) || !isDivisible(input, LOTTO_PRICE.getValue())) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateWinningNumbersInput(String input) {
        if (!isSixNumberAndComma(input) || !isInRangeAndNoDuplicate(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, String input) {
        if (!isPositiveNonZeroInteger(input)) {
            throw new IllegalArgumentException();
        }
        int number = Integer.parseInt(input);
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isPositiveNonZeroInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDivisible(String input, int divisor) {
        int dividend = Integer.parseInt(input);
        return dividend % divisor == 0;
    }

    private static boolean isSixNumberAndComma(String input) {
        return input.matches("^(\\d+,){5}\\d+$");
    }

    private static boolean isInRangeAndNoDuplicate(String input) {
        List<Integer> temp = new ArrayList<>();
        String[] arr = input.split(",");
        for (String s : arr) {
            int i = Integer.parseInt(s);
            if (temp.contains(i) || i < 1 || i > 45) {
                return false;
            }
            temp.add(i);
        }
        return true;
    }
}
