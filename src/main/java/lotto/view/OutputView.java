package lotto.view;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.common.Constant;
import lotto.common.Ranking;
import lotto.model.LottoTickets;

public class OutputView {

    private static final String OUTPUT_LOTTO_NUMBER = "개를 구매했습니다.";
    private static final String OUTPUT_STATISTICS = "당첨 통계";
    private static final String OUTPUT_LINE = "---";
    private static final DecimalFormat PRIZE_FORMAT = new DecimalFormat("#,###");


    public static void printLottoCount(LottoTickets lottoTickets) {
        System.out.println(Constant.LINE.getCharValue() + lottoTickets.getTickets().size() + OUTPUT_LOTTO_NUMBER);
    }

    public static void printLottoList(LottoTickets lottoTickets) {
        printLottoCount(lottoTickets);
        lottoTickets.getTickets().forEach(ticket -> System.out.println(ticket.toString()));
    }

    public static void printWinningDetails(Map<Ranking, Integer> ranks) {
        printWinningDetailsFormat();
        for (Ranking rank : Ranking.values()) {

            Integer counts = ranks.get(rank);
            int matchCount = rank.getMatchCount();

            if(counts == null) {
                counts = 0;
            }
                printStatics(rank, matchCount, counts);
        }
    }

    public static void printStatics(Ranking rank, int matchCount, Integer counts) {
        if (rank == Ranking.SECOND) {
            System.out.println(
                    matchCount + "5개 일치, 보너스 볼 일치 (" + getFormattedPrize(rank.getPrize()) + "원) - " + counts + "개");
        }

        if (rank != Ranking.NONE) {
            System.out.println(
                    matchCount + "개 일치 (" + getFormattedPrize(rank.getPrize()) + "원) - " + counts + "개");
        }
    }

    private static void printWinningDetailsFormat() {
        System.out.println(
                Constant.LINE.getCharValue() + OUTPUT_STATISTICS + Constant.LINE.getCharValue() + OUTPUT_LINE);
    }

    private static String getFormattedPrize(String prize) {
        return PRIZE_FORMAT.format(Integer.parseInt(prize));
    }

    public static void printRateOfReturn(double profit) {
        String formattedProfit = String.format("총 수익률은 %.1f%%입니다.", profit);
        System.out.println(formattedProfit);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

}
