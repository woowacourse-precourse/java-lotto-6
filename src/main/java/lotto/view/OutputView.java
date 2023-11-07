package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import lotto.domain.winning.WinningResult;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    public static final String STATISTICS_HEADER = "당첨 통계";
    public static final String STATISTICS_DIVIDER = "---";
    public static final String WINNING_MATCH_COUNT_MESSAGE = "%d개 일치";
    public static final String BONUS_BALL_MATCH_MESSAGE = "보너스 볼 일치";
    public static final String WINNING_MONEY_MESSAGE = "(%,d원) - %d개";
    public static final String WINNING_STATISTICS_DELIMITER = " ";
    public static final String MATCH_COUNT_DELIMITER = ", ";

    public void printLottos(List<List<Integer>> lottos) {
        System.out.println();
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, lottos.size()));

        lottos.forEach(this::printLotto);
    }

    private void printLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void printStatistics(Map<WinningResult, Integer> statistics) {
        System.out.println();
        System.out.println(STATISTICS_HEADER);
        System.out.println(STATISTICS_DIVIDER);

        statistics.keySet().stream()
                .sorted(Comparator.comparing(WinningResult::getWinningMoney))
                .filter(winningResult -> winningResult != WinningResult.LOSING)
                .forEach(result -> printStatistics(result, statistics.get(result)));
    }

    private void printStatistics(WinningResult winningResult, int count) {
        StringJoiner stringJoiner = new StringJoiner(WINNING_STATISTICS_DELIMITER);
        stringJoiner.add(createMatchCountMessage(winningResult));

        stringJoiner.add(String.format(WINNING_MONEY_MESSAGE, winningResult.getWinningAmount(), count));
        System.out.println(stringJoiner);
    }

    private String createMatchCountMessage(WinningResult winningResult) {
        StringJoiner stringJoiner = new StringJoiner(MATCH_COUNT_DELIMITER);
        stringJoiner.add(String.format(WINNING_MATCH_COUNT_MESSAGE, winningResult.getMatchCount()));

        if (winningResult.needBonusMatch()) {
            stringJoiner.add(BONUS_BALL_MATCH_MESSAGE);
        }

        return stringJoiner.toString();
    }
}
