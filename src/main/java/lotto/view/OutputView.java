package lotto.view;

import static lotto.config.LottoMessage.PURCHASED_AMOUNT_RESULT_MESSAGE;
import static lotto.config.LottoMessage.PURCHASE_AMOUNT_REQUEST_MESSAGE;
import static lotto.config.LottoMessage.WINNING_BONUS_NUMBER_REQUEST_MESSAGE;
import static lotto.config.LottoMessage.WINNING_NUMBER_REQUEST_MESSAGE;
import static lotto.config.LottoMessage.WINNING_STATISTICS;

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

    public static void printWinningBonusNumberRequestMessage() {
        System.out.println(WINNING_BONUS_NUMBER_REQUEST_MESSAGE.getMessage());
    }

    public static void printWinningStatistics(int matchThreeCount, int matchFourCount, int matchFiveCount,
                                              int matchFiveBonusCount, int matchSixCount, String profitRate) {
        System.out.print(WINNING_STATISTICS.getFormatMessage(matchThreeCount, matchFourCount, matchFiveCount,
                matchFiveBonusCount, matchSixCount, profitRate));
    }
}
