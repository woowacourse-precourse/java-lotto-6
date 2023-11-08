package lotto.view;

import java.util.List;
import java.util.Locale;
import lotto.constant.Constant;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

public class OutputView {
    public void printNumberOfTicketsPurchased(List<Lotto> lottoTickets) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTickets.size());
    }

    public void printLottoTicketsDetails(List<Lotto> lottoTickets) {
        StringBuilder lottoTicketsDetails = new StringBuilder();
        for (Lotto lotto : lottoTickets) {
            lottoTicketsDetails.append(lotto).append(System.lineSeparator());
        }
        System.out.println(lottoTicketsDetails.toString());
    }

    public void printLottoPurchaseSummary(List<Lotto> lottoTickets) {
        printNumberOfTicketsPurchased(lottoTickets);
        printLottoTicketsDetails(lottoTickets);
    }

    public void printWinningResult(WinningResult winningResult, List<Lotto> lottoTikets) {
        System.out.printf("당첨 통계%n---%n");
        for (Rank rank : Rank.values()) {
            System.out.printf(Locale.KOREA, "%d개 일치 (%,d원) - %d개%n",
                    rank.getCountOfMatch(), rank.getPrizeMoney(), winningResult.getCount(rank));
        }
        double yield = winningResult.calculateYield(lottoTikets.size() * Constant.LOTTO_PRICE.getValue());
        System.out.printf("총 수익률은 %.1f입니다.%n", yield);
    }
}
