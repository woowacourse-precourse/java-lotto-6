package lotto.view;

import static lotto.domain.constant.Rank.toRank;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.WinningStatistics;

public class Outputs {
    public static void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void showWinningDetails(WinningStatistics results) {
        System.out.println("당첨 통계\n" + "---");
        for (int i = 5; i >= 1; i--) {
            System.out.println(results.getWinningDetail(toRank(i)));
        }
        System.out.println("총 수익률은 " + results.getWinningRate() + "%입니다.");
    }
}
