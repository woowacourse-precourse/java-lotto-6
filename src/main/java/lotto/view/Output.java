package lotto.view;

import java.util.List;

public class Output {
    public static void printPaymentMessage() {
        System.out.println(Messages
                .PAYMENT_MESSAGE
                .getMessage());
    }

    public static void printPurchaseNumber(int purchaseNumber) {
        System.out.println(purchaseNumber + Messages
                .PURCHASE_NUMBER
                .getMessage());
    }

    public static void printPurchasedLottoNumbers(List<List<Integer>> purchasedLottoNumbers) {
        for (int i=0;i<purchasedLottoNumbers.size();i++) {
            System.out.println(purchasedLottoNumbers.get(i));
        }
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

    public static void printWinningStatisticsMessage() {
        System.out.println(Messages
                .CHECK_WINNING_MESSAGE
                .getMessage());
    }
}
