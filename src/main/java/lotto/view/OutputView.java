package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class OutputView {
    public void displayLottoTickets(List<Lotto> lottoTickets) {
        int ticketCount = lottoTickets.size();
        System.out.println("\n" + ticketCount + "개를 구매했습니다.");
        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void displayResults(Map<LottoRank, Integer> results) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                int count = results.getOrDefault(rank, 0);
                System.out.println(formatRankMessage(rank, count));
            }
        }
    }

    private String formatRankMessage(LottoRank rank, int count) {
        String prizeAmountWithComma = String.format("%,d원", rank.getPrizeAmount());
        if (rank == LottoRank.SECOND) {
            return rank.getMatchCount() + "개 일치, 보너스 볼 일치 (" + prizeAmountWithComma + ") - " + count + "개";
        } else {
            return rank.getMatchCount() + "개 일치 (" + prizeAmountWithComma + ") - " + count + "개";
        }
    }

    public void displayProfitRate(String profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }
}

