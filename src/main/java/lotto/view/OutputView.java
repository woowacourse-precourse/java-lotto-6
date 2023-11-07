package lotto.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private List<Integer> ticketNumbers;

    public void printLotteryTickets(int ticketCount, List<List<Integer>> lotteryTickets) {
        System.out.println(ticketCount + "개를 구매했습니다.");
        for (int i = 0; i < ticketCount; i++) {
            ticketNumbers = lotteryTickets.get(i);
            System.out.print(ticketNumbers + "\n");
        }
    }

    public void printWinningStatistics(Map<Integer, Integer> winningTicketsCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + winningTicketsCount.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningTicketsCount.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningTicketsCount.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningTicketsCount.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningTicketsCount.get(1) + "개");

    }

    public void printRevenueRate(String revenueRate) {
        System.out.println("총 수익률은 " + revenueRate + "%입니다.");
    }

}
