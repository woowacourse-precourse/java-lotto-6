package lotto.view;

import java.security.MessageDigest;
import java.util.Arrays;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;

public class LottoStaticsOutputView {

    private static final String RANK_MATCH = "%d개 일치(%d원) - %d개\n";
    private static final String SECOND_RANK_MATCH = "%d개 일치(%d원) + 보너스 번호 일치 - %d개\n";

    public static void outputFrom(WinningStatistics statistics) {
        System.out.println("당첨통계\n---");
        for (Rank rank : Rank.values()) {
          if (rank.equals(Rank.SECOND)) {
          System.out.printf(String.format(SECOND_RANK_MATCH, rank.showMatchCount(), rank.showPrize(), statistics.showCountOf(rank)));
            continue;
          }
          System.out.printf(String.format(RANK_MATCH, rank.showMatchCount(), rank.showPrize(), statistics.showCountOf(rank)));
        }
    }

}
