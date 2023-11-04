package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void showTickets(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.getNumbers().toString());
        }
    }

    public static void showResults(Map<LottoRank, Integer> results, double profitRatio) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) continue;
            System.out.println(rank.getMatchCount() + "개 일치" +
                    (rank == LottoRank.SECOND ? ", 보너스 볼 일치" : "") + " (" +
                    rank.getPrizeMoney() + "원)- " +
                    results.getOrDefault(rank, 0) + "개");
        }

        System.out.println("총 수익률은 " + String.format("%.2f%%", profitRatio) + "입니다.");
    }
}
