package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;

public class OutputView {

    private static final String STATISTIC_FORMAT = "%.1f";

    private OutputView() {
    }

    public static void printUserLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println();
    }

    public static void printLottoResult(List<LottoResult> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---");
        lottoResults.forEach(result -> System.out.println(result.toString()));
    }

    public static void printLottoStatistics(double gainStatistic) {
        System.out.println("총 수익률은 " + String.format(STATISTIC_FORMAT, gainStatistic) + "%입니다.");
    }
}
