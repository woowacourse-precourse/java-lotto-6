package lotto.util;

import lotto.constants.ErrorMessage;

public class WinningNumbersValidator {
    public static final String COMMA = ",";
    public static final int WINNING_NUMBER_LENGTH = 6;

    public static void validate(String winningNumbers) {
        if (!isContainSeparator(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_WRONG_SEPARATOR.getMessage());
        }
        if (!isCorrectSize(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_WRONG_SIZE.getMessage());
        }
        if (!isDigit(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE.getMessage());
        }
    }

    private static boolean isContainSeparator(String winningNumbers) {
        return winningNumbers.contains(COMMA);
    }

    private static boolean isCorrectSize(String winningNumbers) {
        String[] splitWinningNumbers = winningNumbers.split(COMMA);
        return splitWinningNumbers.length == WINNING_NUMBER_LENGTH;
    }

    private static boolean isDigit(String winningNumbers) {
        String[] splitWinningNumbers = winningNumbers.split(COMMA);
        for (String number : splitWinningNumbers) {
            try {
                Integer.parseInt(number.trim());
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }
}
