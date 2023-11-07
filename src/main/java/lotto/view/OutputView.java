package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.StaticsEnum;
import lotto.domain.model.Lotto;
import lotto.domain.model.ResultTable;

public class OutputView {

    public static void displayLottoPurchase(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void displayFinalResult(Map<StaticsEnum, ResultTable> statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        statistics.values().stream()
                .forEach(resultTable -> System.out.println(resultTable.toString()));
    }

    public static void displayTotalProfitRate(double totalProfitRate) {
        System.out.println("총 수익률은 " + totalProfitRate + "%입니다.");
    }
}
