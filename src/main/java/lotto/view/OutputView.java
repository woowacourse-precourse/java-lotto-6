package lotto.view;

import static lotto.constant.OutputMessage.DIVIDING_LINE;
import static lotto.constant.OutputMessage.PROFIT;
import static lotto.constant.OutputMessage.WIN_STATISTICS;
import static lotto.constant.PurchaseMessage.BUY_RECEIPT;

import java.util.List;
import lotto.constant.WinPriceMessage;

public class OutputView {

    public static void printReceipt(int ticket) {
        String printReceiptMessage = String.format(BUY_RECEIPT.getMessage(),
                String.format("%s", ticket));
        printSpace();
        System.out.println(printReceiptMessage);
    }

    public static void printSpace() {
        System.out.println();
    }

    public static void printStatistic() {
        System.out.println(WIN_STATISTICS.getOutputMessage());
        System.out.println(DIVIDING_LINE.getOutputMessage());
    }

    public static void printProfit(long moneySum, int money) {
        double profitRate = calculateProfit(moneySum, money) * 100;
        String profitMessage = String.format(PROFIT.getOutputMessage(),
                String.format("%.1f", profitRate));
        System.out.println(profitMessage);
    }

    private static double calculateProfit(long moneySum, int money) {
        double profit = (double) moneySum / money;
        return Math.round(profit * 1000.0) / 1000.0;
    }

    public static void printAllWinPrices(List<Integer> winCounts) {
        for (WinPriceMessage winPrice : WinPriceMessage.values()) {
            String message = formatWinPriceMessage(winPrice, winCounts.get(winPrice.getIndex()));
            System.out.println(message);
        }
    }

    private static String formatWinPriceMessage(WinPriceMessage winPriceMessage, int winCount) {
        return String.format("%s (%,d원) - %d개", winPriceMessage.getMessage(),
                winPriceMessage.getPrize(), winCount);
    }
}