package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static final String OUTPUT_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    public static final String OUTPUT_WINNING_STATISTICS_MESSAGE = "당첨 통계";
    public static final String OUTPUT_WINNING_STATISTICS_DIVIDER = "---------";
    public static final String OUTPUT_WINNING_MONEY_FORMAT = "%d개 일치 (%s원) - %d개";
    public static final String OUTPUT_WINNING_MONEY_FORMAT_WITH_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    public static final String OUTPUT_PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottoCount(int lottoCount) {
        System.out.println(String.format(OUTPUT_LOTTO_COUNT_MESSAGE, lottoCount));
    }

    public static void printWinningLottos(List<Lotto> winningLottos) {
        for(Lotto lotto : winningLottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningStatistics(Map<Rank, Integer> rankCountMap) {
        System.out.println(OUTPUT_WINNING_STATISTICS_MESSAGE);
        System.out.println(OUTPUT_WINNING_STATISTICS_DIVIDER);

        for(Rank rank : Rank.values()) {
            if(rank == Rank.NONE) {
                continue;
            }

            if(rank == Rank.SECOND) {
                System.out.println(String.format(OUTPUT_WINNING_MONEY_FORMAT_WITH_BONUS_FORMAT, rank.getMatchCount(), String.format("%,d", rank.getWinningMoney()), rankCountMap.get(rank)));
                continue;
            }

            System.out.println(String.format(OUTPUT_WINNING_MONEY_FORMAT, rank.getMatchCount(), String.format("%,d", rank.getWinningMoney()), rankCountMap.get(rank)));
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.println(String.format(OUTPUT_PROFIT_RATE_MESSAGE, profitRate));
    }
}
