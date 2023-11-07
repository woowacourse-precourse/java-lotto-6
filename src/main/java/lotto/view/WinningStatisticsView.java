package lotto.view;

import lotto.constant.message.WinningStatisticsMessage;
import lotto.constant.SystemData;
import lotto.model.WinningCondition;

import java.text.DecimalFormat;

public class WinningStatisticsView {

    public static void printHeader() {
        System.out.println(WinningStatisticsMessage.TITLE);
        System.out.println(WinningStatisticsMessage.DIVIDER);
    }

    public static void printContent(WinningCondition winningCondition, int count) {
        printCorrectCount(winningCondition);
        printWinningPrice(winningCondition);
        printWinningCount(count);
        System.out.println();
    }

    private static void printCorrectCount(WinningCondition winningCondition){
        System.out.printf(WinningStatisticsMessage.WINNING_NUMBER_CORRECT, winningCondition.winningNumberCount());
        if (winningCondition.bonusNumberCount() > 0) {
            System.out.printf(", " + WinningStatisticsMessage.BONUS_NUMBER_CORRECT);
        }
    }

    private static void printWinningPrice(WinningCondition winningCondition){
        int winningAmount = winningCondition.winningAmount();
        DecimalFormat moneyFormat = SystemData.MONEY_FORMAT;
        System.out.printf(" " + WinningStatisticsMessage.WINNING_AMOUNT, moneyFormat.format(winningAmount));
    }

    private static void printWinningCount(int count){
        System.out.printf(" " + WinningStatisticsMessage.WINNING_COUNT, count);
    }

    public static void printTotalProfitResult(float profitRate) {
        System.out.printf((WinningStatisticsMessage.TOTAL_PROFIT_RESULT) + "%n", profitRate);
    }
}
