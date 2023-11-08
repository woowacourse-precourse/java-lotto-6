package lotto.view;

import static lotto.config.LottoMessage.PURCHASED_AMOUNT_RESULT_MESSAGE;
import static lotto.config.LottoMessage.PURCHASE_AMOUNT_REQUEST_MESSAGE;
import static lotto.config.LottoMessage.BONUS_NUMBER_REQUEST_MESSAGE;
import static lotto.config.LottoMessage.WINNING_NUMBER_REQUEST_MESSAGE;
import static lotto.config.LottoMessage.WINNING_STATISTICS;

import java.util.List;

public class OutputView {
    public static void printPurchaseAmountRequestMessage() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE.getMessage());
    }

    public static void printPurchasedAmountResultMessage(int purchasedAmount) {
        System.out.printf(PURCHASED_AMOUNT_RESULT_MESSAGE.getFormatMessage(purchasedAmount));
    }

    public static void printWinningNumberRequestMessage() {
        System.out.println(WINNING_NUMBER_REQUEST_MESSAGE.getMessage());
    }

    public static void printBonusNumberRequestMessage() {
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE.getMessage());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printPurchasedLotto(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printWinningStatistics(int fifthPrizeCount, int fourthPrizeCount, int thirdPrizeCount,
                                              int secondPrizeCount, int firstPrizeCount, String profitRate) {
        System.out.print(WINNING_STATISTICS.getFormatMessage(fifthPrizeCount, fourthPrizeCount, thirdPrizeCount,
                secondPrizeCount, firstPrizeCount, profitRate));
    }
}
