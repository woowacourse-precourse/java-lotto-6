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
        int firstPlaceCount = resultOfLottos.getOrDefault(1, 0);
        int secondPlaceCount = resultOfLottos.getOrDefault(2, 0);
        int thirdPlaceCount = resultOfLottos.getOrDefault(3, 0);
        int fourthPlaceCount = resultOfLottos.getOrDefault(4, 0);
        int fifthPlaceCount = resultOfLottos.getOrDefault(5, 0);

        return new StringBuilder()
                .append(Reward.FIFTH_PLACE.getValue())
                .append(String.format(HYPHEN_COUNT, fifthPlaceCount))
                .append(LINE_FEED)
                .append(Reward.FOURTH_PLACE.getValue())
                .append(String.format(HYPHEN_COUNT, fourthPlaceCount))
                .append(LINE_FEED)
                .append(Reward.THIRD_PLACE.getValue())
                .append(String.format(HYPHEN_COUNT, thirdPlaceCount))
                .append(LINE_FEED)
                .append(Reward.SECOND_PLACE.getValue())
                .append(String.format(HYPHEN_COUNT, secondPlaceCount))
                .append(LINE_FEED)
                .append(Reward.FIRST_PLACE.getValue())
                .append(String.format(HYPHEN_COUNT, firstPlaceCount))
                .toString();
    }

    private static String convertToString(double profitRate) {
        return String.format(PROFIT_RATE_MESSAGE, profitRate);
    }
}
