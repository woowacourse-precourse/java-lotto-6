package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.constants.ViewMessage.*;

public class View {

    public String inputValue() {
        return Console.readLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printNewLine() {
        printMessage("\n");
    }

    public void printPurchaseAmountPrompt() {
        printMessage(INPUT_PURCHASE_AMOUNT.message());
    }

    public void printPurchasedTickets(int numberOfTickets) {
        printNewLine();
        printMessage(PURCHASED_TICKETS.format(numberOfTickets));
    }

    public void printTickets(List<List<Integer>> tickets) {
        for (List<Integer> ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public void printWinningNumberPrompt() {
        printNewLine();
        printMessage(INPUT_WINNING_NUMBERS.message());
    }

    public void printBonusNumberPrompt() {
        printNewLine();
        printMessage(INPUT_BONUS_NUMBER.message());
    }

    public void printWinningStatistics(int[] matchCounts, long[] prizeAmounts, double profitRate) {
        StringBuilder statistics = new StringBuilder(WINNING_STATISTICS.message());
        for (int i = 0; i <= 4; i++) {
            if (i == 3 && matchCounts[i] > 0) {
                statistics.append("\n").append(MATCH_INCLUDE_BONUS.format(prizeAmounts[i], matchCounts[i]));
            }
            statistics.append("\n").append(MATCH_EXCEPT_BONUS.format(i, prizeAmounts[i], matchCounts[i]));
        }
        statistics.append("\n").append(TOTAL_PROFIT_RATE.format(String.format("%.1f", profitRate)));

        printMessage(statistics.toString());
    }
}
