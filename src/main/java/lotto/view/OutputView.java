package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.enums.WinningRank;

public class OutputView {
    private static final String PAY_SUCCESS_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String WINNING_RANK_FIFTH_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String WINNING_RANK_FOURTH_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String WINNING_RANK_THIRD_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String WINNING_RANK_SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String WINNING_RANK_FIRST_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String COUNT_UNIT_MESSAGE = "개";

    public static void printPaySuccessMessageMessage(int lotteCount) {
        System.out.println();
        System.out.println(lotteCount + PAY_SUCCESS_MESSAGE);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            System.out.print("[");
            lotto.printNumbers();
            System.out.println("]");
        });

    }

    public static void printWinningStatisticsMessage() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println("---");
    }

    public static void printWinningStatistics(HashMap<WinningRank, Integer> winningStatistics) {
        System.out.println(
                WINNING_RANK_FIFTH_MESSAGE + winningStatistics.get(WinningRank.FIFTH) + COUNT_UNIT_MESSAGE);
        System.out.println(
                WINNING_RANK_FOURTH_MESSAGE + winningStatistics.get(WinningRank.FOURTH) + COUNT_UNIT_MESSAGE);
        System.out.println(
                WINNING_RANK_THIRD_MESSAGE + winningStatistics.get(WinningRank.THIRD) + COUNT_UNIT_MESSAGE);
        System.out.println(
                WINNING_RANK_SECOND_MESSAGE + winningStatistics.get(WinningRank.SECOND) + COUNT_UNIT_MESSAGE);
        System.out.println(
                WINNING_RANK_FIRST_MESSAGE + winningStatistics.get(WinningRank.FIRST) + COUNT_UNIT_MESSAGE);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
