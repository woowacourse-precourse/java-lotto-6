package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.WinningStats;

public class OutputView {
    private static final String WINNING_STATS_PREFIX_MESSAGE = "당첨통계\n---";
    private static final String RATE_OF_RETURN_FORMAT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void showErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void showLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void showWinningStatsIntroduction() {
        System.out.println(WINNING_STATS_PREFIX_MESSAGE);
    }

    public static void showWinningStatsResult(WinningStats winningStats) {
        System.out.println(winningStats.getResultMessage());
    }

    public static void showRateOfReturn(WinningStats winningStats) {
        System.out.println(String.format(RATE_OF_RETURN_FORMAT_MESSAGE, winningStats.getRateOfReturn()));
    }
}
