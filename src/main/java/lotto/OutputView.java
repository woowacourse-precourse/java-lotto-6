package lotto;

import java.util.List;
import java.util.stream.Collectors;
public class OutputView {

    public static void printResults(Results lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("----");

        for (Ranking ranking : Ranking.values()) {
            if (ranking != Ranking.NONE) {
                int count = lottoResult.getCount(ranking);
                System.out.println(ranking.getMessage() + " - " + count + "개");
            }
        }

        System.out.printf("총 수익률은 %.1f%%입니다.", lottoResult.calculateEarningsRate());
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(formatLottoNumbers(lotto.getNumbers()));
        }
    }

    private static String formatLottoNumbers(List<Integer> numbers) {
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }
}
