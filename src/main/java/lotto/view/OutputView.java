package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    public void printPurchaseLottoNumbers(List<Lotto> lottos) {
        System.out.println();
        System.out.printf("%d개를 구매하였습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public void printLottoStatistics(Map<Rank, Integer> rankIntegerMap) {;
        for (Rank rank : Rank.values()) {
            if (rank == Rank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", rank.getCount(), rank.getWinningAmount(), rankIntegerMap.getOrDefault(rank, 0));
                continue;
            }
            System.out.printf("%d개 일치 (%,d원) - %d개%n", rank.getCount(), rank.getWinningAmount(), rankIntegerMap.getOrDefault(rank, 0));
        }
    }

    public void printStatisticsMessage() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
