package lotto.view;

import java.util.List;
import lotto.Util.Message;
import lotto.model.User;

public class Output {
    public static void printRequestPaymentMessage() {
        System.out.println(Message
                .REQUEST_PAYMENT
                .getMessage());
    }

    public static void printAboutPurchase(User user) {
        printNumberOfPurchase(user.numberOfPurchase());
        printPurchasedLottoNumbers(user.purchasedLottoNumbers());
    }

    public static void printNumberOfPurchase(int numberOfPurchase) {
        System.out.println(numberOfPurchase + Message
                .NUMBER_OF_PURCHASE
                .getMessage());
    }

    public static void printPurchasedLottoNumbers(List<List<Integer>> purchasedLottoNumbers) {
        for (int i = 0; i < purchasedLottoNumbers.size(); i++) {
            System.out.println(purchasedLottoNumbers.get(i));
        }
    }

    public static void printRequestWinningNumbersMessage() {
        System.out.println(Message
                .REQUEST_WINNING_NUMBERS
                .getMessage());
    }

    public static void printRequestBonusNumberMessage() {
        System.out.println(Message
                .REQUEST_BONUS_NUMBER
                .getMessage());
    }

    public static void printStatistics(List<Integer> rankCount) {
        System.out.println(Message.CHECK_WINNING_MESSAGE.getMessage());
        Message[] messages = {
                Message.FIRST_PLACE_MESSAGE,
                Message.SECOND_PLACE_MESSAGE,
                Message.THIRD_PLACE_MESSAGE,
                Message.FOURTH_PLACE_MESSAGE,
                Message.FIFTH_PLACE_MESSAGE
        };

        for (int i = 5; i >= 1; i--) {
            System.out.printf(messages[i - 1].getMessage(), rankCount.get(i));
        }
    }

    public static void printYield(double yield) {
        System.out.printf(Message.TOTAL_YIELD_MESSAGE.getMessage(), yield);
    }
}
