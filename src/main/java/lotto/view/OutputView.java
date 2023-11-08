package lotto.view;

import lotto.constants.AppConstants;
import lotto.constants.MsgConstants;
import lotto.domain.LottoPrize;

import java.text.DecimalFormat;

import static lotto.constants.MsgConstants.WINNING_STATISTICS_RESULT_PRIZE;
import static lotto.constants.MsgConstants.WINNING_STATISTICS_RESULT_SECOND_PRIZE;

public class OutputView {

    public static void printErrorMessage(String err) {
        System.out.println(err);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printEnterPurchaseAmount() {
        printMessage(MsgConstants.PLEASE_ENTER_PURCHASE_AMOUNT.getData());
    }

    public static void printPurchasedLottoNumber(String msg) {
        printMessage(msg);
    }

    public static void printEnterWinningNumber() {
        printMessage(MsgConstants.PLEASE_ENTER_WINNING_NUMBER.getData());
    }

    public static void printEnterBonusNumber() {
        printMessage(MsgConstants.PLEASE_ENTER_BONUS_NUMBER.getData());
    }

    public static void printPurchasedQuantity(int quantity) {
        printMessage(String.format(MsgConstants.PURCHASED_SOME_PIECES.getData(), quantity));
    }

    public static void printWinningStatistics(int[] winningCount) {
        printMessage(MsgConstants.WINNING_STATISTICS.getData());
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            printPrize(lottoPrize, winningCount[lottoPrize.ordinal()]);
        }
    }

    private static void printPrize(LottoPrize lottoPrize, int count) {
        String messageKey = WINNING_STATISTICS_RESULT_PRIZE.getData();

        if (lottoPrize == LottoPrize.SECOND) {
            messageKey = WINNING_STATISTICS_RESULT_SECOND_PRIZE.getData();
        }

        System.out.printf(messageKey + "\n", lottoPrize.getMatchCount(),
                getFormattedPrize(lottoPrize.getPrize()), count);
    }

    private static String getFormattedPrize(int prize) {
        DecimalFormat decimalFormat = new DecimalFormat(AppConstants.LOTTO_PRIZE_FORMAT);
        return decimalFormat.format(prize);
    }

    public static void printProfitRatio(double ratio) {
        System.out.printf(MsgConstants.WINNING_STATISTICS_RESULT_RATIO.getData() + "%n", ratio);
    }
}