package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.MatchNumber;

public class OutputMessage {
    public static void printPurchaseAmount(int purchasePrice, List<Lotto> lottos) {
        System.out.println(purchasePrice / 1000 + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResult(Map<MatchNumber, Integer> statistics, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", statistics.getOrDefault(MatchNumber.THREE, 0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", statistics.getOrDefault(MatchNumber.FOUR, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", statistics.getOrDefault(MatchNumber.FIVE, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
                statistics.getOrDefault(MatchNumber.FIVE_WITH_BONUS, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", statistics.getOrDefault(MatchNumber.SIX, 0));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);

    }

}
