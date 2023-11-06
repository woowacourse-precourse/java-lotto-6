package lotto.userInterface;

import lotto.constants.Error;

public class ErrorMessageViewer {
    private static final Error INVALID_AMOUNT = Error.INVALID_AMOUNT;
    private static final Error INVALID_FIRST_RANK_NUMBERS = Error.INVALID_FIRST_RANK_NUMBERS;
    private static final Error INVALID_BONUS_NUMBER = Error.INVALID_BONUS_NUMBER;
    private static final Error NO_AMOUNT = Error.NO_AMOUNT;
    private static final Error NO_FIRST_RANK_NUMBER = Error.NO_FIRST_RANK_NUMBERS;
    private static final Error NO_BONUS_NUMBER = Error.NO_BONUS_NUMBER;

    private ErrorMessageViewer() {
    }

    public static void printInvalidAmount() {
        System.out.println(INVALID_AMOUNT.getMessage());
    }

    public static void printInvalidFirstRankNumbers() {
        System.out.println(INVALID_FIRST_RANK_NUMBERS.getMessage());
    }

    public static void printInvalidBonusNumber() {
        System.out.println(INVALID_BONUS_NUMBER.getMessage());
    }

    public static void printNoAmount() {
        System.out.println(NO_AMOUNT.getMessage());
    }

    public static void printNoFirstRankNumbers() {
        System.out.println(NO_FIRST_RANK_NUMBER.getMessage());
    }

    public static void printNoBonusNumber() {
        System.out.println(NO_BONUS_NUMBER.getMessage());
    }
}
