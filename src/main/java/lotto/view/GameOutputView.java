package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

import java.util.List;

public class GameOutputView {
    private static final String LOTTO_PURCHASE_QUANTITY = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String PRIZE_MONEY_FORMAT = "%,d";
    private static final int DEFAULT_WINNING_COUNT = 0;
    private static final String RESULT_FORMAT = "%d개 일치%s (%s원) - %d개";
    private static final String BONUS_MATCH = ", 보너스 볼 일치";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + LOTTO_PURCHASE_QUANTITY);
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getSortedNumbers();

            System.out.println(lottoNumbers);
        }
    }

    public void showWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println(WINNING_STATISTICS);
        for (Rank rank : Rank.values()) {
            if (rank== Rank.NONE) continue;

            String result = getResult(rank, winningStatistics);

            System.out.println(result);
        }

        String profitRate = getProfitRate(winningStatistics);
        System.out.println(profitRate);
    }

    private String getResult(Rank rank, WinningStatistics winningStatistics) {
        int matchCount = rank.getMatchCount();
        String bonusMatch = getBonusMatch(rank);
        String prizeMoney = String.format(PRIZE_MONEY_FORMAT, rank.getPrizeMoney());
        Integer winningCount = winningStatistics.getWinningCount().getOrDefault(rank, DEFAULT_WINNING_COUNT);

        String result = String.format(RESULT_FORMAT,
                matchCount,
                bonusMatch,
                prizeMoney,
                winningCount);

        return result;
    }

    private String getBonusMatch(Rank rank) {
        String bonusMatch = "";
        if (rank.isBonusMatch()) {
            bonusMatch = BONUS_MATCH;
        }
        return bonusMatch;
    }

    private String getProfitRate(WinningStatistics winningStatistics) {
        return String.format(PROFIT_RATE_FORMAT, winningStatistics.getProfitRate());
    }
}
