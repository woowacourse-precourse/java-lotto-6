package lotto.userInterface;

import lotto.constants.Error;

public class ErrorMessageViewer {
    private static final Error INVALID_AMOUNT = Error.INVALID_AMOUNT;
    private static final Error INVALID_FIRST_RANK_NUMBERS = Error.INVALID_FIRST_RANK_NUMBERS;
    private static final Error INVALID_BONUS_NUMBER = Error.INVALID_BONUS_NUMBER;

    private ErrorMessageViewer() {
    }

    public static void printInvalidAmount() {
        System.out.println("\n" + INVALID_AMOUNT.getMessage());
    }

    public static void printInvalidFirstRankNumbers() {
        System.out.println("\n" + INVALID_FIRST_RANK_NUMBERS.getMessage());
    }

    public static void printInvalidBonusNumber() {
        System.out.println("\n" + INVALID_BONUS_NUMBER.getMessage());
    }
}
