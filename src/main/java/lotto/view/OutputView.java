package lotto.view;

import java.util.Map;
import lotto.domain.Rank;

public class OutputView {
    public void printLottoStatistics(Map<Rank, Integer> rankIntegerMap) {;
        for (Rank rank : Rank.values()) {
            if (rank == Rank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", rank.getCount(), rank.getWinningAmount(), rankIntegerMap.getOrDefault(rank, 0));
                continue;
            }
            System.out.printf("%d개 일치 (%,d원) - %d개%n", rank.getCount(), rank.getWinningAmount(), rankIntegerMap.getOrDefault(rank, 0));
        }
    }

}
