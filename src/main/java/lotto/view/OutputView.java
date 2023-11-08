package lotto.view;

import lotto.domain.LottoCollector;

public class OutputView {
    private static final String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_DETAIL_MESSAGE = "\n당첨 통계\n---";
    private static final String TOTAL_YIELD_START = "총 수익률은 ";
    private static final String TOTAL_YIELD_END = "%입니다.";
    public static void printPublishedLottos(LottoCollector lottoCollector) {

        System.out.println();
        System.out.println(lottoCollector.getTicketCount() + TICKET_COUNT_MESSAGE);
        System.out.println(lottoCollector.convertLottoToString());
    }

    public static void printWinningDetail(String winningDetail) {
        System.out.println(WINNING_DETAIL_MESSAGE);
        System.out.print(winningDetail);
    }

    public static void printYieldRate(String yieldRate) {
        System.out.println(TOTAL_YIELD_START + yieldRate + TOTAL_YIELD_END);
    }
}
