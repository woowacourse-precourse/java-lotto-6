package lotto.view;

import java.util.List;
import lotto.model.User;

public class Output {
    public static void printRequestPayment() {
        System.out.println(PrintMessages
                .REQUEST_PAYMENT
                .getMessage());
    }

    public static void printAboutPurchase(User user) {
        printPurchaseNumber(user.purchaseNumber());
        printPurchasedLottoNumbers(user.PurchasedLottoNumbers());
    }

    public static void printPurchaseNumber(int purchaseNumber) {
        System.out.println(purchaseNumber + PrintMessages
                .PURCHASE_NUMBER
                .getMessage());
    }

    public static void printPurchasedLottoNumbers(List<List<Integer>> purchasedLottoNumbers) {
        for (int i = 0; i < purchasedLottoNumbers.size(); i++) {
            System.out.println(purchasedLottoNumbers.get(i));
        }
    }

    public static void printRequestWinningNumbers() {
        System.out.println(PrintMessages
                .REQUEST_WINNING_NUMBERS
                .getMessage());
    }

    public static void printRequestBonusNumber() {
        System.out.println(PrintMessages
                .REQUEST_BONUS_NUMBER
                .getMessage());
    }

    // 수정 필요
    public static void printStatistics(List<Integer> rankCount, double winnings, double payment) {
        System.out.println(PrintMessages
                .CHECK_WINNING_MESSAGE
                .getMessage());
        System.out.println("3개 일치 (5,000원) - " + rankCount.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCount.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCount.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCount.get(1) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.", winnings / payment * 100);
    }
}
