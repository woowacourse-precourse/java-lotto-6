package lotto.view;

import java.util.Map;
import lotto.domain.Rank;

public class ResultView {

    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String RATE_PREFIX = "총 수익률은 ";
    private static final String RATE_EXPRESSION = "%.1f";
    private static final String RATE_POSTFIX = "%입니다.";
    private static final String COUNT_MESSAGE = "개";


    public void lottoResultPrint(Map<Rank, Integer> result, double earningRate) {
        System.out.println(WINNING_STATISTICS);
        result.forEach(ResultView::missCheck);
        earningRatePrint(earningRate);
    }

    private static void missCheck(Rank rank, Integer matchCount) {
        if (rank != Rank.MISS) {
            System.out.println(rank.message + matchCount + COUNT_MESSAGE);
        }
    }

    public void earningRatePrint(double earningRate) {
        System.out.println(RATE_PREFIX + String.format(RATE_EXPRESSION, earningRate) + RATE_POSTFIX);
    }
}
