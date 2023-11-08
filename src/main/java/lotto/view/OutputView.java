package lotto.view;

import java.util.List;
import java.util.Map;

import lotto.common.enums.LottoRank;
import lotto.domain.Lotto;

public class OutputView {

    public static void printLottos(int count, List<Lotto> lottos) {
        System.out.println("\n" + count + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void presentResults(Map<LottoRank, Long> winCategory, double rateOfReturn) {
        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", winCategory.getOrDefault(LottoRank.FIFTH, 0L));
        System.out.printf("4개 일치 (50,000원) - %d개\n", winCategory.getOrDefault(LottoRank.FOURTH, 0L));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winCategory.getOrDefault(LottoRank.THIRD, 0L));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winCategory.getOrDefault(LottoRank.SECOND, 0L));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winCategory.getOrDefault(LottoRank.FIRST, 0L));

        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn * 100);
    }

}
