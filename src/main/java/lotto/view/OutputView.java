package lotto.view;

import lotto.model.Lotto;
import lotto.model.PrizeRank;
import lotto.model.Result;

import java.util.List;

import static lotto.model.PrizeRank.*;

public class OutputView {

    public void printPurchaseCount(int purchaseCount) {
        System.out.printf("%s개를 구매했습니다.\n", purchaseCount);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStatistics(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%s원) - %s개\n", numberFormatter(FIFTH), result.getCountByRank(FIFTH));
        System.out.printf("4개 일치 (%s원) - %s개\n", numberFormatter(FOURTH), result.getCountByRank(FOURTH));
        System.out.printf("5개 일치 (%s원) - %s개\n", numberFormatter(THIRD), result.getCountByRank(THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %s개\n", numberFormatter(SECOND), result.getCountByRank(SECOND));
        System.out.printf("6개 일치 (%s원) - %s개\n", numberFormatter(FIRST), result.getCountByRank(FIRST));
    }

    private static String numberFormatter(PrizeRank first) {
        return String.format("%,d", first.getPrice());
    }

}
