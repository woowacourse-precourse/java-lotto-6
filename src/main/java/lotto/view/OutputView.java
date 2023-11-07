package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.config.Rank;

public class OutputView {

    private OutputView() {
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf(("%n%s개를 구매했습니다.%n"), lottos.size());
        System.out.println(lottos.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    public static void printResults(Map<Rank, Long> results) {
        System.out.printf("%n당첨 통계%n---%n%s", formatResults(results));
    }

    private static String formatResults(Map<Rank, Long> results) {
        StringBuilder stringBuilder = new StringBuilder();
        results.entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.NO_RANK)
                .forEach(entry -> stringBuilder.append(formatRank(entry.getKey(), entry.getValue())));
        return stringBuilder.toString();
    }

    private static String formatRank(Rank rank, long count) {
        if (rank == Rank.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n",
                    rank.matchedCount, formatPrize(rank), count);
        }
        return String.format("%d개 일치 (%s원) - %d개%n",
                rank.matchedCount, formatPrize(rank), count);
    }

    private static String formatPrize(Rank rank) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(rank.prize);
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);

    }

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
