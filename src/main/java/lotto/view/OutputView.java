package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;
import java.util.HashMap;
import java.util.List;

public class OutputView {

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getSortedNumbers());
        }
    }

    public static void printLottoResult(HashMap<Rank, Integer> lottoResult) {
        System.out.println("\n당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() >= 3) {
                System.out.println(rank.getMessage() + lottoResult.get(rank) + "개");
            }
        }
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }
}
