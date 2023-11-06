package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoRank;

public class LottoResultPrinter {
    public static void printLottos(int count, List<Lotto> lottos) {
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void presentResults(List<Integer> winsPerCategory, double rateOfReturn) {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", winsPerCategory.get(LottoRank.FIFTH.ordinal()));
        System.out.printf("4개 일치 (50,000원) - %d개\n", winsPerCategory.get(LottoRank.FOURTH.ordinal()));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winsPerCategory.get(LottoRank.THIRD.ordinal()));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winsPerCategory.get(LottoRank.SECOND.ordinal()));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winsPerCategory.get(LottoRank.FIRST.ordinal()));

        System.out.printf("총 수익률은 %.2f%%입니다.\n", rateOfReturn * 100);
    }
}
