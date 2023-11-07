package lotto.view;

import static lotto.util.content.DisplayMessage.END_CONTENT;
import static lotto.util.content.DisplayMessage.GET_PURCHASE_AMOUNT;
import static lotto.util.content.DisplayMessage.NEXT_LINE;
import static lotto.util.content.DisplayMessage.POINT_FORMAT;
import static lotto.util.content.DisplayMessage.RESULT_FORMAT;
import static lotto.util.content.DisplayMessage.RESULT_TITLE;
import static lotto.util.content.DisplayMessage.TOTAL_YIELD;

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
        System.out.println(NEXT_LINE.getContent() + RESULT_TITLE.getContent());
        int totalPrizeAmount = 0;
        for (int i = rank.length - 1; i >= 0; i--) {
            String prize = RankingRule.values()[i].getPrize();
            String rankContent = RankingRule.values()[i].getContent();
            int count = rank[i];
            System.out.println(
                    String.format(RESULT_FORMAT.getContent(), rankContent, prize, count));
            if (count > 0) {
                totalPrizeAmount += Integer.parseInt(
                        prize.replace(",", "")) * count;
            }
        }
        double profitRate = (double) totalPrizeAmount / purchaseAmount * 100;
        System.out.println(
                TOTAL_YIELD.getContent() + String.format(POINT_FORMAT.getContent(), profitRate)
                        + END_CONTENT.getContent());
    }

    public static void displayErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

}
