package lotto.view;

import static lotto.util.content.DisplayMessage.END_CONTENT;
import static lotto.util.content.DisplayMessage.GET_PURCHASE_AMOUNT;
import static lotto.util.content.DisplayMessage.NEXT_LINE;
import static lotto.util.content.DisplayMessage.POINT_FORMAT;
import static lotto.util.content.DisplayMessage.RESULT_FORMAT;
import static lotto.util.content.DisplayMessage.RESULT_TITLE;
import static lotto.util.content.DisplayMessage.TOTAL_YIELD;
import static lotto.util.content.ErrorMessage.ERROR_WORD;

import java.util.List;
import lotto.domain.Ticket;
import lotto.util.rule.RankingRule;

public class OutputView {

    public static void displayTicket(List<Ticket> tickets) {
        System.out.println(NEXT_LINE.getContent() +
                tickets.size() + GET_PURCHASE_AMOUNT.getContent());
        for (Ticket ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }

    public static void displayStatistic(int[] rank, Integer purchaseAmount) {
        displayStatisticTitle();
        int totalPrizeAmount = calculateTotalPrizeAmount(rank);
        double profitRate = calculateRate(totalPrizeAmount, purchaseAmount);
        displayTotalYield(profitRate);
    }

    public static void displayErrorMessage(IllegalArgumentException e) {
        System.out.println(ERROR_WORD.getContent() + e.getMessage());
    }

    private static void displayStatisticTitle() {
        System.out.println(NEXT_LINE.getContent() + RESULT_TITLE.getContent());
    }

    private static int calculateTotalPrizeAmount(int[] rank) {
        int totalPrizeAmount = 0;
        for (int i = rank.length - 1; i >= 0; i--) {
            String prize = RankingRule.values()[i].getPrize();
            String rankContent = RankingRule.values()[i].getContent();
            int count = rank[i];

            String formattedResult = String.format(RESULT_FORMAT.getContent(), rankContent, prize,
                    count);
            System.out.println(formattedResult);

            if (count > 0) {
                totalPrizeAmount += parsePrizeAmount(prize) * count;
            }
        }
        return totalPrizeAmount;
    }

    private static int parsePrizeAmount(String prize) {
        return Integer.parseInt(prize.replace(",", ""));
    }

    private static double calculateRate(int totalPrizeAmount, Integer purchaseAmount) {
        return (double) totalPrizeAmount / purchaseAmount * 100;
    }

    private static void displayTotalYield(double profitRate) {
        System.out.println(
                TOTAL_YIELD.getContent() + String.format(POINT_FORMAT.getContent(), profitRate)
                        + END_CONTENT.getContent());
    }


}
