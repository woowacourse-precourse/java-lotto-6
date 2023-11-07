package lotto.view;

import lotto.constant.message.WinningStatisticsMessage;
import lotto.constant.SystemData;
import lotto.model.WinningCondition;

public class WinningStatisticsView {

    public static void printHeader() {
        System.out.println(WinningStatisticsMessage.TITLE);
        System.out.println(WinningStatisticsMessage.DIVIDER);
    }

    public static void printContent(WinningCondition winningCondition, int count) {
        System.out.printf(WinningStatisticsMessage.WINNING_NUMBER_CORRECT, winningCondition.winningNumberCount());
        if (winningCondition.containBonusNumber()) {
            System.out.printf(", " + WinningStatisticsMessage.BONUS_NUMBER_CORRECT);
        }

        System.out.printf(" " + WinningStatisticsMessage.WINNING_AMOUNT, winningCondition.winningAmount());
        System.out.printf(" " + WinningStatisticsMessage.WINNING_COUNT, count);
        System.out.println();
    }

    public static void printTotalProfitResult(float profitRate) {
        System.out.printf((WinningStatisticsMessage.TOTAL_PROFIT_RESULT) + "%n", profitRate);
    }
}
