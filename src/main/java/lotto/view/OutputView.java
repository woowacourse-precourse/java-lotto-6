package lotto.view;

import static lotto.constants.Constants.INITIAL_COUNT;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    private static final String PURCHASE_LOTTO_MESSAGE = "%d개를 구매했습니다.%n";
    private static final String SECOND_RANK_STATISTICS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    private static final String RANK_STATISTICS_MESSAGE = "%d개 일치 (%,d원) - %d개%n";
    private static final String STATISTICS_MESSAGE = "%n당첨 통계%n---%n";
    private static final String PROFIT_RAT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printPurchaseLottoNumbers(List<Lotto> lottos) {
        System.out.println();
        System.out.printf(PURCHASE_LOTTO_MESSAGE, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public void printLottoStatistics(Map<Rank, Integer> rankIntegerMap) {;
        for (Rank rank : Rank.values()) {
            if (rank == Rank.SECOND) {
                System.out.printf(SECOND_RANK_STATISTICS_MESSAGE, rank.getCount(), rank.getWinningAmount(), rankIntegerMap.getOrDefault(rank,
                        INITIAL_COUNT));
                continue;
            }
            System.out.printf(RANK_STATISTICS_MESSAGE, rank.getCount(), rank.getWinningAmount(), rankIntegerMap.getOrDefault(rank, INITIAL_COUNT));
        }
    }

    public void printStatisticsMessage() {
        System.out.printf(STATISTICS_MESSAGE);
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RAT_MESSAGE, profitRate);
    }
}
