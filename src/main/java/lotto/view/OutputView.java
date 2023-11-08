package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Ranking;

public class OutputView {

    public static void showLottoTickets(List<Lotto> lottoTickets) {
        System.out.println();
        System.out.println(String.format("%d개를 구매했습니다.", lottoTickets.size()));
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getNumbers());
        }
    }

    public static void showResult(LottoResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format("3개 일치 (5,000원) - %d개", result.getRankingCount(Ranking.FIFTH)));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", result.getRankingCount(Ranking.FOURTH)));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", result.getRankingCount(Ranking.THIRD)));
        System.out.println(
                String.format("5개 일치, 보너스 볼 일치(30,000,000원) - %d개", result.getRankingCount(Ranking.SECOND)));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", result.getRankingCount(Ranking.FIRST)));
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", result.getRevenue()));
    }
}
