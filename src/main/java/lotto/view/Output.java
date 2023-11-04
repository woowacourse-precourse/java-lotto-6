package lotto.view;

public class Output {
    public static void printPaymentMessage() {
        System.out.println(Messages
                .PAYMENT_MESSAGE
                .getMessage());
    }

    public static void printPurchaseNumber() {
        System.out.println(Messages
                .PURCHASE_NUMBER
                .getMessage());
    }

    public static void printUserLotto() {
        System.out.println();
    }

    public static void printWinningNumbersMessage() {
        System.out.println(Messages
                .WINNING_NUMBERS_MESSAGE
                .getMessage());
    }

    public static void printBonusNumberMessage() {
        System.out.println(Messages
                .BONUS_NUMBER_MESSAGE
                .getMessage());
    }

    public static void printCheckWinningMessage() {
        System.out.println(Messages
                .CHECK_WINNING_MESSAGE
                .getMessage());
    }
}
