package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Ranking;

public class ResultView {
    private static final String TICKET_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계\n---";
    private static final String REVENUE_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String MATCH_MESSAGE_FORMAT = "%s: %d개";

    public static void printTicketCount(int count) {
        System.out.printf((TICKET_COUNT_MESSAGE) + "%n", count);
    }

    public static void printSuccessResult() {
        System.out.println(WINNING_STATISTICS_HEADER);
    }

    public static void printMatchCount(Ranking ranking, int count) {
        if (ranking != Ranking.NO_PRIZE) {
            String message = String.format(MATCH_MESSAGE_FORMAT, ranking.getDescription(), count);
            System.out.println(message);
        }
    }

    public static void printRevenueRate(double earningRate) {
        System.out.printf((REVENUE_RATE_MESSAGE) + "%n", earningRate);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public static void printResults(Map<Ranking, Long> resultMap) {
        for (Ranking ranking : Ranking.values()) {
            printMatchCount(ranking, Math.toIntExact(resultMap.getOrDefault(ranking, 0L)));
        }
    }
}
