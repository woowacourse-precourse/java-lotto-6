package lotto.util;

import lotto.service.LottoGame;

import java.util.List;

public class InputValidator {

    public static boolean isDividedInto1000(int amount) {
        if (amount % LottoGame.LOTTO_PRICE == 0) {
            return true;
        }
        return false;
    }

    public static boolean isPositive(int amount) {
        return amount > 0;
    }

    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInRange(int parsedInput) {
        return parsedInput >= LottoGame.MIN_LOTTO_NUMBER
                && parsedInput <= LottoGame.MAX_LOTTO_NUMBER;
    }

    public static boolean isValidSplitSize(String[] split) {
        return split.length == LottoGame.LOTTO_SELECTION_COUNT;
    }

    public static boolean isDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }
}
