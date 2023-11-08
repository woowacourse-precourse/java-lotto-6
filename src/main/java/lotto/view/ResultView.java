package lotto.view;

import java.util.Map;
import lotto.domain.LottoResult;
import lotto.domain.LottoStatistic;

public class ResultView {
    public static void printLottoStatistic(LottoStatistic statistic) {
        Map<LottoResult, Integer> map = statistic.getStaticsMap();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (int i = LottoResult.values().length - 1; i >= 0; i--) {
            LottoResult result = LottoResult.values()[i];
            if (result == LottoResult.FAIL) {
                continue;
            }
            System.out.print(result.getDescription() + " - ");
            System.out.println(map.get(result) + "개");
        }

        System.out.println("총 수익률은 " + statistic.getTotalEarnRate() + "%입니다.");
    }
}
