package lotto.view;

import java.util.Map;
import lotto.constant.LottoRanking;
import lotto.dto.LottoResult;

public class OutputView {

    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계";
    private static final String LINE = "---";

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.println(LINE);
        printWinningCounts(lottoResult.winningCounts());
        printProfitRate(lottoResult.profitRate());
    }

    private static void printWinningCounts(Map<LottoRanking, Integer> winningCounts) {
        for (LottoRanking lottoRanking : winningCounts.keySet()) {
            String message = lottoRanking.getWinningCondition()
                    + " - "
                    + winningCounts.get(lottoRanking)
                    + "개";
            System.out.println(message);
        }
    }

    private static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
