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

    public static void printStatistics(List<Integer> numberOfWin) {
        System.out.println("3개 일치 (5,000원) - " + numberOfWin.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + numberOfWin.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + numberOfWin.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + numberOfWin.get(7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + numberOfWin.get(6) + "개");
    }
}
