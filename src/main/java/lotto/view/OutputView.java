package lotto.view;

import static lotto.view.Messages.BLANK;
import static lotto.view.Messages.COUNT_UNIT;
import static lotto.view.Messages.DASH;
import static lotto.view.Messages.PROFIT_RATE_MESSAGE;
import static lotto.view.Messages.RESULT_MESSAGE;

import lotto.domain.Ranking;
import lotto.domain.RankingResult;

public class OutputView {

    public static void println(final String message) {
        System.out.println(message);
    }

    public static void printResult(RankingResult results) {
        System.out.println(RESULT_MESSAGE);

        for (Ranking ranking : Ranking.values()) {
            final int count = results.findCountByRanking(ranking);

            System.out.println(ranking.getMessage() + BLANK + DASH + BLANK + count + COUNT_UNIT);
        }
    }

    public static void printProfitRate(final double profitRate) {
        String message = String.format(PROFIT_RATE_MESSAGE, profitRate);
        System.out.println(message);
    }
}
