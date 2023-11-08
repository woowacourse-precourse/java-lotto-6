package lotto.view;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.enums.Rank;

public class OutputView {
    private static final String RESULT_HEADER = "\n당첨 통계\n---\n";
    private static final String DECIMAL_PATTERN = "#,###";
    private static final String MATCH_RANK = "개 일치";
    private static final String MATCH_BONUS = ", 보너스 볼 일치 ";
    private static final String PRICE_COUNT = "(%s원) - %d개\n";
    private static final String SPACE = " ";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        lottos.lottosInfo().stream()
                .map(Lotto::toString)
                .forEach(System.out::println);
    }

    public static void printResult(Map<Rank, Integer> result, double rateOfReturn) {
        System.out.printf(RESULT_HEADER);
        printCompareResult(result);
        printRateOfReturn(rateOfReturn);
    }

    private static void printCompareResult(Map<Rank, Integer> result) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_PATTERN);
        for (Rank rank : Rank.getRanks()) {
            System.out.printf(rank.getCount() + MATCH_RANK + getBonus(rank));
            System.out.printf(PRICE_COUNT, decimalFormat.format(rank.getPrizeMoney()), getCount(result, rank));

        }
    }

    private static String getBonus(Rank rank) {
        if (rank.isBonus()) {
            return MATCH_BONUS;
        }
        return SPACE;
    }

    private static int getCount(Map<Rank, Integer> result, Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    private static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}