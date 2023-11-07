package lotto.func;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class Rank {

    public void myRanking(List<Integer> winningNumbers, int bonus, List<List<Integer>> lottoTickets) {
        int[] matchCount = new int[WinningRank.values().length];

        for (List<Integer> ticket : lottoTickets) {
            int ticketMatchCount = countMatchingNumbers(ticket, winningNumbers);
            boolean hasBonusMatch = ticket.contains(bonus);

            WinningRank rank = WinningRank.calculateRank(ticketMatchCount, hasBonusMatch);
            if (rank != null) {
                matchCount[rank.ordinal()]++;
            }
        }
        winningStatistics(matchCount, lottoTickets.size());
    }
    private void winningStatistics(int[] matchCount, int totalTickets) {
        System.out.println("당첨 통계");
        System.out.println("---");
        int[] prizes = {5000, 50000, 1500000, 30000000, 2000000000};
        int totalPrize = 0;

        for (WinningRank rank : WinningRank.values()) {
            int index = rank.ordinal();
            totalPrize += matchCount[index] * prizes[index];
            System.out.printf("%s (%,d원) - %d개\n", rank.getDescription(), prizes[index], matchCount[index]);
        }
        calculateProfitRate(totalPrize, totalTickets);
    }

    private void calculateProfitRate(int totalPrize, int totalTickets) {
        int totalCost = totalTickets * 1000;
        double profitRate = ((double) totalPrize / totalCost) * 100;

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String formattedProfitRate = decimalFormat.format(profitRate);

        System.out.println("총 수익률은 " + formattedProfitRate + "%입니다.");
    }

    private int countMatchingNumbers(List<Integer> ticket, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : ticket) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
