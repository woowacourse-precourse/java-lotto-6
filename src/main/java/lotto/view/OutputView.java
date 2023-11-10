package lotto.view;

import java.util.HashMap;
import java.util.List;
import java.text.NumberFormat;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;

public class OutputView {
    public static void outputPurchaseLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());

        }

    }

    public static void checkWinningList(List<LottoRanking> winnings) {
        HashMap<LottoRanking, Integer> winningList = new HashMap<>();
        NumberFormat numberFormat = NumberFormat.getInstance();
        Integer totalPrize = 0;

        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoRanking winning : winnings) {
            winningList.put(winning, winningList.getOrDefault(winning, 0) + 1);
            totalPrize += winning.getWinningAmount();
        }
        for (LottoRanking ranking : LottoRanking.values()) {
            if (ranking.getCountOfMatch() != 0) {
                System.out.printf("%d개 일치", ranking.getCountOfMatch());
                if (ranking == LottoRanking.SECOND) {
                    System.out.print(", 보너스 볼 일치");
                }
                System.out.printf(" (%s원) - %d개%n",
                        numberFormat.format(ranking.getWinningAmount()),
                        winningList.getOrDefault(ranking, 0));
            }
        }

        double test = Math.round(totalPrize.floatValue() / (winnings.size() * 1000) * 100 * 10) / 10.0;

        System.out.println("총 수익률은 " + test + "%입니다.");

    }

}
