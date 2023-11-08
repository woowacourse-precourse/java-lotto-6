package lotto.view;

import lotto.constant.Rank;
import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String LOTTO_COUNT = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String DIVISION_LINE = "---";
    private static final String WINNING_STATISTICS_FORMAT = "%s (%s원) - %d개";

    public void showLottoCount(int count) {
        System.out.println(count + LOTTO_COUNT);
    }

    public void showLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    private String formatStatistics(Rank rank, int count){
        return String.format(
                WINNING_STATISTICS_FORMAT,
                rank.getStandard(),
                rank.getMoney(),
                count);
    }

    public void showWinningStatistics(HashMap<String, Integer> winningStatistics) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVISION_LINE);

        for (Rank rank: Rank.values()) {
            String rankTag = String.valueOf(rank);
            System.out.println(formatStatistics(rank, winningStatistics.get(rankTag)));
        }
    }
}
