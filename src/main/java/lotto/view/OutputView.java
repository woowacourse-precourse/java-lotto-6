package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Reward;

public class OutputView {
    private static final String PAID_DONE_MESSAGE = "개를 구매했습니다.";
    private static final String STATISTICS_MESSAGE = "당첨 통계\n---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String HYPHEN_COUNT = " - %d개";
    private static final String LINE_FEED = "\n";
    private static final String EMPTY = "";

    private OutputView() {
    }

    public static void printLottos(List<List<Integer>> lottos) {
        print(lottos.size() + PAID_DONE_MESSAGE);
        lottos.forEach(System.out::println);
        print(EMPTY);
    }

    public static void printWinningStatistics(Map<Integer, Integer> resultOfLottos, double profitRate) {
        print(STATISTICS_MESSAGE);
        print(parseMapToString(resultOfLottos));
        print(convertToString(profitRate));
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static String parseMapToString(Map<Integer, Integer> resultOfLottos) {
        return new StringBuilder()
                .append(Reward.FIFTH_PLACE.getValue()).append(getCountOfRankToString(resultOfLottos, 5))
                .append(LINE_FEED)
                .append(Reward.FOURTH_PLACE.getValue()).append(getCountOfRankToString(resultOfLottos, 4))
                .append(LINE_FEED)
                .append(Reward.THIRD_PLACE.getValue()).append(getCountOfRankToString(resultOfLottos, 3))
                .append(LINE_FEED)
                .append(Reward.SECOND_PLACE.getValue()).append(getCountOfRankToString(resultOfLottos, 2))
                .append(LINE_FEED)
                .append(Reward.FIRST_PLACE.getValue()).append(getCountOfRankToString(resultOfLottos, 1))
                .toString();
    }

    private static String getCountOfRankToString(Map<Integer, Integer> resultOfLottos, int rank) {
        return String.format(HYPHEN_COUNT, resultOfLottos.getOrDefault(rank, 0));
    }

    private static String convertToString(double profitRate) {
        return String.format(PROFIT_RATE_MESSAGE, profitRate);
    }
}
