package lotto.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Rank;

public class OutputView {
    private static final String LOTTO_QUANTITY_NOTIFY_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String NEW_LINE = "\n";
    private static final String DASH = "-";
    private static final String DUPLICATE_NOTIFY_MESSAGE = "%d개 일치";
    private static final String BONUS_NOTIFY_MESSAGE = ", 보너스 볼 일치";
    private static final String SPACE = " ";
    private static final String PRIZE_MESSAGE = "(%,d원)";
    private static final String WINNING_LOTTO_NUMBER_MESSAGE = "%d개";
    private static final String EARNING_RATE_NOTIFY_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printLottoQuantity(int lottoQuantity) {
        System.out.print(NEW_LINE);
        System.out.println(String.format(LOTTO_QUANTITY_NOTIFY_MESSAGE, lottoQuantity));
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> sortedLotto = new ArrayList<>(lotto.getNumbers());
            sortLottoAscendingOrder(sortedLotto);
            System.out.println(sortedLotto);
        }
    }

    private static void sortLottoAscendingOrder(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public static void printStatistics(Map<Rank, Integer> finalResult) {
        System.out.println(NEW_LINE + WINNING_STATISTICS_MESSAGE + NEW_LINE + DASH.repeat(3));
        Rank[] ranksSpreadInOrder = Rank.values();

        for (Rank rank : ranksSpreadInOrder) {
            StringBuilder statistics = new StringBuilder();
            statistics.append(String.format(DUPLICATE_NOTIFY_MESSAGE, rank.getCountDuplication()));
            if (rank.getCheckBonus()) {
                statistics.append(BONUS_NOTIFY_MESSAGE);
            }
            statistics.append(SPACE).append(String.format(PRIZE_MESSAGE, rank.getPrize())).append(SPACE + DASH + SPACE)
                    .append(String.format(WINNING_LOTTO_NUMBER_MESSAGE, finalResult.get(rank)));
            System.out.println(statistics);
        }
    }

    public static void printEarningRate(double earningRate) {
        System.out.println(String.format(EARNING_RATE_NOTIFY_MESSAGE, earningRate));
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}