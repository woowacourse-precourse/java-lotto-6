package lotto.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class ValidationImpl implements Validation {
    private final int NUMBER_START = 1;
    private final int NUMBER_END = 45;
    private final Pattern WINNING_NUMBER_PATTERN = Pattern.compile("[^,\\d]");
    private final Pattern BONUS_NUMBER_PATTERN = Pattern.compile("\\D");
    private final Pattern MONEY_PATTERN = Pattern.compile("\\D");

    @Override
    public boolean isValidWinningNumbers(String input) {
        if (hasSpecialCharExceptComma(input)) {
            return false;
        }
        String[] strings = input.split(",");
        for (String string : strings) {
            if (!existDigitBetweenComma(string)
                    || !isBetween(Integer.parseInt(string))) {
                return false;
            }
        }
        if (isDistinctNumbers(input)) {
            return true;
        }
        return false;
    }

    private boolean hasSpecialCharExceptComma(String input) {
        return WINNING_NUMBER_PATTERN.matcher(input).find();
    }

    private boolean existDigitBetweenComma(String string) {
        if (string.length() < 1) {
            return false;
        }
        return true;
    }

    private boolean isDistinctNumbers(String input) {
        String[] strings = input.split(",");
        Set<Integer> distinctNumbers = new HashSet<>();
        for (String string : strings) {
            distinctNumbers.add(Integer.parseInt(string));
        }
        if (distinctNumbers.size() < strings.length) {
            return false;
        }
        return true;
    }

    private boolean isBetween(int number) {
        if (number < NUMBER_START || number > NUMBER_END) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isValidBonusNumber(String input) {
        return !BONUS_NUMBER_PATTERN.matcher(input).find()
                && isBetween(Integer.parseInt(input));
    }

    @Override
    public boolean isValidMoney(String input) {
        return !MONEY_PATTERN.matcher(input).find();
    }
}
