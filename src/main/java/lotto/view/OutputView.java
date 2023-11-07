package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;

import static lotto.domain.LottoResult.*;

public class OutputView {

    private static final String BUY_RESULT_MSG = "개를 구매했습니다.";
    public static final String RESULT_MSG = "당첨 통계";
    public static final String CHANGE_LINE_MSG = "---";
    public static final String NORMAL_RESULT_MSG = "%d개 일치 (%,d원) - %d개\n";
    public static final String ABNORMAL_RESULT_MSG = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void showPurchasedLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + BUY_RESULT_MSG);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void showLottoResult(long payment, List<Rank> results) {
        System.out.println();
        System.out.println(RESULT_MSG);
        System.out.println(CHANGE_LINE_MSG);

        for (Rank rank : getRankValues()) {
            if (!rank.isBonus()) {
                System.out.printf(NORMAL_RESULT_MSG, rank.getCount(), rank.getPrize(), rankCount(rank, results));
                continue;
            }
            System.out.printf(ABNORMAL_RESULT_MSG, rank.getCount(), rank.getPrize(), rankCount(rank, results));
        }

        System.out.printf(TOTAL_YIELD_MESSAGE, (totalEarningRate(results) * 100 /payment));
    }
}
