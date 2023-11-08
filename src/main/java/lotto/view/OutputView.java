package lotto.view;

import java.util.Arrays;
import lotto.model.Revenue;
import lotto.model.lotto.LottoRank;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.RankCount;

public class OutputView {
    private final String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.";
    private final String STATS_MESSAGE = "\n당첨 통계";
    private final String DIVIDE_DELIMETER = "---";
    private final String COUNT_FORMAT = "개";
    private final String REVENUE_MESSAGE = "총 수익률은 %s%%입니다.";


    public void printLottoTicketCount(int lottoTicketCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE + "%n", lottoTicketCount);
    }

    public void printLottos(LottoTicket lottoTicket){
        System.out.println(lottoTicket.toString());
    }

    public void printLottoResult(RankCount rankCount) {
        System.out.println(STATS_MESSAGE);
        System.out.println(DIVIDE_DELIMETER);
        printRankResult(rankCount);
    }

    public void printRevenue(Revenue revenue){
        String revenueFormatted = revenue.getValue();
        System.out.printf(REVENUE_MESSAGE + "%n", revenueFormatted);
    }

    private void printRankResult(RankCount rankCount) {
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.FAIL)
                .forEach(rank -> System.out.println(rank.getMessage() + rankCount.getCounts(rank) + COUNT_FORMAT));
    }
    
}
