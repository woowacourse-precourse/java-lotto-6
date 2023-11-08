package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.Statistics;

public class OutputView {
    public static final String FRONT_BRACKETS = "[";
    public static final String REAR_BRACKETS = "]";
    public static final String COMMAS = ",";
    public static final String STATISTICS_HEADER = System.lineSeparator() + "당첨 통계" + System.lineSeparator() + "---";
    public static final String BUYING_COUNT = "%d개를 구매했습니다.";
    public static final String STATISTICS = "%d개 일치%s(%s원) - %d개" + System.lineSeparator();
    public static final String TAKE_BONUS = ", 보너스 볼 일치 ";
    public static final String PROFIT = "총 수익률은 %.1f%%입니다.";


    public static void printAutoLottoList(List<Lotto> autoLottoList) {
        for (Lotto lotto : autoLottoList) {
            printLottoNumbers(lotto);
        }
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.numbersWithForm());
    }

    public static void printLottoResult(Result result) {
        System.out.println(STATISTICS_HEADER);
        for (Statistics statistics : Statistics.getWithoutDefault()) {
            System.out.printf(String.format(STATISTICS,
                    statistics.getNumberMatchCount(), printWinSecond(statistics),
                    NumberFormat.getNumberInstance(Locale.US).format(statistics.getReward()),
                    result.getRankCount(statistics)
            ));
        }
    }

    private static String printWinSecond(final Statistics statistics) {
        if (statistics.equals(Statistics.SECOND)) {
            return TAKE_BONUS;
        }
        return " ";
    }

    public static void printProfit(float profit) {
        System.out.printf(PROFIT, profit);
    }
}
