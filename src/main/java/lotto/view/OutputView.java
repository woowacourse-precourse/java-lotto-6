package lotto.view;

import lotto.constants.AppConstants;
import lotto.constants.MsgConstants;
import lotto.domain.LottoPrize;

import java.text.DecimalFormat;

import static lotto.constants.MsgConstants.*;

public class OutputView {


    public static void printErrorMessage(String err) {
        System.out.println(err);
    }


    public static void printEnterPurchaseAmount() {
        System.out.println(MsgConstants.PLEASE_ENTER_PURCHASE_AMOUNT.getData());
    }

    public static void printPurchasedLottoNumber(String msg) {
        System.out.println(msg);
    }

    public static void printEnterWinningNumber() {
        System.out.println(MsgConstants.PLEASE_ENTER_WINNING_NUMBER.getData());
    }

    public static void printEnterBonusNumber() {
        System.out.println(MsgConstants.PLEASE_ENTER_BONUS_NUMBER.getData());
    }

    public static void printPurchasedQuantity(int quantity) {
        System.out.printf((PURCHASED_SOME_PIECES.getData()) + "%n", quantity);
    }

    public static void printWinningStatistics(int[] winningCount) {
        System.out.println(WINNING_STATISTICS.getData());
        LottoPrize[] values = LottoPrize.values();
        for (LottoPrize lottoPrize : values) {
            printPrize(lottoPrize, winningCount[lottoPrize.ordinal()]);
        }
    }

    private static void printPrize(LottoPrize lottoPrize, int count) {
        String messageKey = WINNING_STATISTICS_RESULT_PRIZE.getData();

        if (lottoPrize == LottoPrize.SECOND) {
            messageKey = WINNING_STATISTICS_RESULT_SECOND_PRIZE.getData();
        }

        System.out.printf(messageKey, lottoPrize.getMatchCount(),
                getFormattedPrize(lottoPrize.getPrize()), count);
    }

    private static String getFormattedPrize(int prize) {
        DecimalFormat decimalFormat = new DecimalFormat(AppConstants.LOTTO_PRIZE_FORMAT);
        return decimalFormat.format(prize);
    }

    public static void printProfitRatio(double ratio) {
        System.out.printf((WINNING_STATISTICS_RESULT_RATIO.getData()) + "%n", ratio);
    }
}