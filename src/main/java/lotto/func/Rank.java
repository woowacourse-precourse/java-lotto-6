package lotto.func;

import java.util.List;

public class Rank {

    public void myRanking(List<Integer> winningNumbers, int bonus, List<List<Integer>> lottoTickets) {
        int[] matchCount = new int[5];

        for (List<Integer> ticket : lottoTickets) {
            int ticketMatchCount = countMatchingNumbers(ticket, winningNumbers);
            boolean hasBonusMatch = ticket.contains(bonus);

            if (ticketMatchCount == 6) {
                matchCount[4]++; // 1등
            } else if (ticketMatchCount == 5) {
                if (hasBonusMatch) {
                    matchCount[3]++; // 2등
                } else {
                    matchCount[2]++; // 3등
                }
            } else if (ticketMatchCount == 4) {
                matchCount[1]++; // 4등
            } else if (ticketMatchCount == 3) {
                matchCount[0]++; // 5등
            }
        }
        winningStatistics(matchCount);
    }

    private void winningStatistics(int[] matchCount) {
        System.out.println("당첨 통계");
        String[] ranks = { "3개 일치", "4개 일치", "5개 일치", "5개 일치, 보너스 볼 일치", "6개 일치" };
        int[] prizes = { 5000, 50000, 1500000, 30000000, 2000000000 };

        for (int i = 0; i < ranks.length; i++) {
            System.out.printf("%s (%,d원) - %d개\n", ranks[i], prizes[i], matchCount[i]);
        }
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
