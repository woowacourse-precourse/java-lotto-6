package lotto.view;

import lotto.model.Lotto;
import lotto.model.PrizeRank;
import lotto.model.Result;

import java.text.NumberFormat;
import java.util.List;

import static lotto.model.PrizeRank.*;

public class OutputView {

    public void printPurchaseCount(int purchaseCount) {
        System.out.printf("\n%s개를 구매했습니다.\n", purchaseCount);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStatistics(Result result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%s원) - %s개\n", numberFormatter(FIFTH), result.getCountByRank(FIFTH));
        System.out.printf("4개 일치 (%s원) - %s개\n", numberFormatter(FOURTH), result.getCountByRank(FOURTH));
        System.out.printf("5개 일치 (%s원) - %s개\n", numberFormatter(THIRD), result.getCountByRank(THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %s개\n", numberFormatter(SECOND), result.getCountByRank(SECOND));
        System.out.printf("6개 일치 (%s원) - %s개\n", numberFormatter(FIRST), result.getCountByRank(FIRST));
    }

    public void printProfitRate(Double rate) {
        NumberFormat nf = createNumberFormat();
        System.out.println("총 수익률은 " + nf.format(rate) + "%입니다.");
    }

    private static NumberFormat createNumberFormat() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(1);
        nf.setMaximumFractionDigits(1);
        return nf;
    }


    private static String numberFormatter(PrizeRank first) {
        return String.format("%,d", first.getPrice());
    }

}
