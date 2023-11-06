package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

public class LottoStaticsOutputView {

    private static final String RANK_MATCH = "%d개 일치 (%,d원) - %d개\n";
    private static final String SECOND_RANK_MATCH = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";

    public static void outputFrom(WinningStatistics statistics) {
        System.out.println("당첨통계\n---");
        List<Rank> ranks = Arrays.stream(Rank.values())
                                 .filter(rank -> !rank.equals(Rank.NONE))
                                 .sorted(Comparator.reverseOrder())
                                 .toList();
        for (Rank rank : ranks) {

            if (rank.equals(Rank.SECOND)) {
                System.out.printf(SECOND_RANK_MATCH, rank.showMatchCount(), rank.showPrize(),
                        statistics.showCountOf(rank));
                continue;
            }
            System.out.printf(RANK_MATCH, rank.showMatchCount(), rank.showPrize(), statistics.showCountOf(rank));
        }
    }

}
