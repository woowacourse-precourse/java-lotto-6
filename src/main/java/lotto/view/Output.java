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
    public static void printStatistics(List<Integer> rankCount, double result, double payment) {
        System.out.println(PrintMessages
                .CHECK_WINNING_MESSAGE
                .getMessage());
        System.out.printf(PrintMessages.FIFTH_PLACE_MESSAGE.getMessage(), rankCount.get(5));
        System.out.printf(PrintMessages.FOURTH_PLACE_MESSAGE.getMessage(), rankCount.get(4));
        System.out.printf(PrintMessages.THIRD_PLACE_MESSAGE.getMessage(), rankCount.get(3));
        System.out.printf(PrintMessages.SECOND_PLACE_MESSAGE.getMessage(), rankCount.get(2));
        System.out.printf(PrintMessages.FIRST_PLACE_MESSAGE.getMessage(), rankCount.get(1));
        System.out.printf(PrintMessages.TOTAL_YIELD_MESSAGE.getMessage(), result / payment * 100);
    }
}
