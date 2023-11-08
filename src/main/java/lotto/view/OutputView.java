package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Ranking;

public class OutputView {

    public static final String RESPONSE_LOTTO_QUANTITY = "%d개를 구매했습니다.";
    public static final String RESPONSE_FIFTH_RANK = "3개 일치 (5,000원) - %d개";
    public static final String RESPONSE_FOURTH_RANK = "4개 일치 (50,000원) - %d개";
    public static final String RESPONSE_THIRD_RANK = "5개 일치 (1,500,000원) - %d개";
    public static final String RESPONSE_SECOND_RANK = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    public static final String RESPONSE_FIRST_RANK = "6개 일치 (2,000,000,000원) - %d개";
    public static final String RESPONSE_REVENUE = "총 수익률은 %.1f%%입니다.";
    public static final String RESPONSE_START_LOTTO_RESULT = "당첨 통계";
    public static final String RESPONSE_PERFORATION_LINE = "---";

    public static void showLottoTickets(List<Lotto> lottoTickets) {
        System.out.println();
        System.out.println(String.format(RESPONSE_LOTTO_QUANTITY, lottoTickets.size()));
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getNumbers());
        }
    }

    public static void showResult(LottoResult result) {
        System.out.println();
        System.out.println(RESPONSE_START_LOTTO_RESULT);
        System.out.println(RESPONSE_PERFORATION_LINE);
        System.out.println(String.format(RESPONSE_FIFTH_RANK, result.getRankingCount(Ranking.FIFTH)));
        System.out.println(String.format(RESPONSE_FOURTH_RANK, result.getRankingCount(Ranking.FOURTH)));

        System.out.println(String.format(RESPONSE_THIRD_RANK, result.getRankingCount(Ranking.THIRD)));
        System.out.println(
                String.format(RESPONSE_SECOND_RANK, result.getRankingCount(Ranking.SECOND)));
        System.out.println(String.format(RESPONSE_FIRST_RANK, result.getRankingCount(Ranking.FIRST)));
        System.out.println(String.format(RESPONSE_REVENUE, result.getRevenue()));
    }
}
