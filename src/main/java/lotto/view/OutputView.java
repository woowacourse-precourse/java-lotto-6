package lotto.view;

import java.util.List;
import java.util.Locale;
import lotto.constant.Constant;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

public class OutputView {
    public void printLottoPurchaseSummary(List<Lotto> lottoTickets) {
        printNumberOfTicketsPurchased(lottoTickets);
        printLottoTicketsDetails(lottoTickets);
    }

    private void printNumberOfTicketsPurchased(List<Lotto> lottoTickets) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTickets.size());
    }

    private void printLottoTicketsDetails(List<Lotto> lottoTickets) {
        StringBuilder lottoTicketsDetails = new StringBuilder();
        for (Lotto lotto : lottoTickets) {
            lottoTicketsDetails.append(String.format("%s%n", lotto));
        }
        System.out.println(lottoTicketsDetails.toString());
    }


    public void printWinningResult(WinningResult winningResult, List<Lotto> lottoTickets) {
        StringBuilder summary = new StringBuilder();
        summary.append(String.format("당첨 통계%n---%n"));
        
        for (Rank rank : Rank.values()) {
            summary.append(formatRankResult(rank, winningResult));
        }
        
        double yield = winningResult.calculateYield(lottoTickets.size() * Constant.LOTTO_PRICE.getValue());
        summary.append(String.format("총 수익률은 %.1f%%입니다.%n", yield));
        
        System.out.print(summary.toString());
    }
    
    private String formatRankResult(Rank rank, WinningResult winningResult) {
        String bonusMatch = "";
        if (rank == Rank.SECOND) {
            bonusMatch = ", 보너스 볼 일치";
        }
        return String.format(Locale.KOREA, "%d개 일치%s (%,d원) - %d개%n",
                rank.getCountOfMatch(),
                bonusMatch,
                rank.getPrizeMoney(),
                winningResult.getCount(rank));
    }
}
