package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class ResultView {

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(formatLottoNumbers(lotto.getNumbers()));
        }
    }

    public static void printWinningResults(Map<LottoRank, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                String prizeFormat = String.format("%,d원", rank.getPrize());
                String matchMessage = rank.getMatchCount() + "개 일치";

                if (rank == LottoRank.SECOND) {
                    matchMessage += ", 보너스 볼 일치";
                }

                System.out.printf("%s (%s) - %d개\n",
                        matchMessage,
                        prizeFormat,
                        results.getOrDefault(rank, 0));
            }
        }
    }


    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield * 100);
    }

    private static String formatLottoNumbers(List<Integer> numbers) {
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }
}
