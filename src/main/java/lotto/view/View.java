package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.LottoPrize;

import static lotto.constants.ViewMessage.*;

public class View {

    public String inputValue() {
        return Console.readLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printPurchaseAmountPrompt() {
        printMessage(INPUT_PURCHASE_AMOUNT.message());
    }

    public void printPurchasedTickets(int numberOfTickets) {
        printNewLine();
        printMessage(PURCHASED_TICKETS.format(numberOfTickets));
    }

    public void printWinningNumberPrompt() {
        printNewLine();
        printMessage(INPUT_WINNING_NUMBERS.message());
    }

    public void printBonusNumberPrompt() {
        printNewLine();
        printMessage(INPUT_BONUS_NUMBER.message());
    }

    public void printMatchStatistics(int[] matchCounts, double profitRate) {
        printNewLine();
        printMessage(WINNING_STATISTICS.message());
        for (int i = 3; i <= 6; i++) {
            printFormattedMatchCount(i, matchCounts[i], LottoPrize.PRIZES[i]);
        }
        printFormattedMatchCountWithBonus(matchCounts[7], LottoPrize.PRIZES[7]);
        printTotalProfitRate(profitRate);
    }


    private void printFormattedMatchCount(int matchCount, int ticketCount, long prizeAmount) {
        printMessage(MATCH_EXCEPT_BONUS.format(matchCount, prizeAmount, ticketCount));
    }

    private void printFormattedMatchCountWithBonus(int ticketCount, long prizeAmount) {
        printMessage(MATCH_INCLUDE_BONUS.format( prizeAmount, ticketCount));
    }

    private void printTotalProfitRate(double profitRate) {
        printMessage(String.format(TOTAL_PROFIT_RATE.message(), String.format("%.1f", profitRate)));
    }
}
