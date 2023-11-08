package lotto.view.outputView;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import lotto.model.Revenue;
import lotto.model.lotto.LottoRank;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.RankCount;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String STATS_MESSAGE = "\n당첨 통계";
    private static final String DIVIDE_DELIMETER = "---";
    private static final String COUNT_FORMAT = "개";
    private static final String REVENUE_MESSAGE = "총 수익률은 %s%%입니다.";


    public static void printLottoTicketCount(int lottoTicketCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE + "%n", lottoTicketCount);
    }

    public static void printLottos(LottoTicket lottoTicket){
        System.out.println(lottoTicket.toString());
    }

    public static void printLottoResult(RankCount rankCount) {
        System.out.println(STATS_MESSAGE);
        System.out.println(DIVIDE_DELIMETER);
        printRankResult(rankCount);
    }

    public static void printRevenue(Revenue revenue){
        String revenueFormatted = revenue.getRevenue();
        System.out.printf(REVENUE_MESSAGE + "%n", revenueFormatted);
    }

    private static void printRankResult(RankCount rankCount) {
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.FAIL)
                .forEach(rank -> System.out.println(rank.getMessage() + rankCount.getCounts(rank) + COUNT_FORMAT));
    }



}
