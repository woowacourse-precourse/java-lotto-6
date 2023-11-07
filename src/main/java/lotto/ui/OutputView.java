package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.Rank;

public class OutputView {
    private static String LOTTO_QUANTITY_NOTIFY_MESSAGE = "%d개를 구매했습니다.";
    private static String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static String NEW_LINE = "\n";
    private static String DASH = "-";
    private static String OVERLAP_NOTIFY_MESSAGE = "%d개 일치";
    private static String OVERLAP_AND_BONUS_NOTIFY_MESSAGE = "%d개 일치, 보너스 볼 일치";
    private static String SPACE = " ";
    private static String PRIZE_MESSAGE = "(%,d원)";
    private static String WINNING_LOTTO_NUMBER_MESSAGE = "%d개";
    private static String EARNING_RATE_NOTIFY_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printLottoQuantity(int lottoQuantity) {
        System.out.print(NEW_LINE);
        System.out.println(String.format(LOTTO_QUANTITY_NOTIFY_MESSAGE, lottoQuantity));
    }

    public static void printStatistics(Map<Rank, Integer> finalResult) {
        System.out.println(NEW_LINE + WINNING_STATISTICS_MESSAGE + NEW_LINE + DASH + DASH + DASH);
        Rank[] ranks = Rank.values();
        for (int i = 0; i < ranks.length; i++) {
            StringBuilder statistics = new StringBuilder();
            if (!ranks[i].getChecked()) {
                statistics.append(String.format(OVERLAP_NOTIFY_MESSAGE, ranks[i].getCounted())).append(SPACE);
            }
            if (ranks[i].getChecked()) {
                statistics.append(String.format(OVERLAP_AND_BONUS_NOTIFY_MESSAGE, ranks[i].getCounted())).append(SPACE);
            }
            statistics.append(String.format(PRIZE_MESSAGE, ranks[i].getPrize())).append(SPACE + DASH + SPACE)
                    .append(String.format(WINNING_LOTTO_NUMBER_MESSAGE, finalResult.get(ranks[i])));
            System.out.println(statistics);
        }
    }

    public static void printEarningRate(double earningRate) {
        System.out.println(String.format(EARNING_RATE_NOTIFY_MESSAGE, earningRate));
    }
}