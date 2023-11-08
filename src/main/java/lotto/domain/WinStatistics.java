package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class WinStatistics {

    private static final String STATISTICS = "\n당첨 통계\n";
    private static final String DIVIDER = "---\n";
    private static final String COUNTER = "개\n";
    private static final String TOTAL_REVENUE = "총 수익률은 ";
    private static final String END = "%입니다.";
    private static final int RATE = 100;
    private static final int UNIT = 1000;



    public static String getStatisticsString(List<Integer> scores, long revenue) {
        double payed = scores.size() * UNIT;
        BigDecimal winAmount = BigDecimal.valueOf(calculatePercentage(revenue, payed));
        return toString(scores, winAmount);
    }

    private static String toString(List<Integer> scores, BigDecimal percentage) {
        PrizeLevel[] prizeLevels = PrizeLevel.values();
        StringBuilder sb = new StringBuilder();
        sb.append(STATISTICS).append(DIVIDER);
        for (int i = 0; i < prizeLevels.length; i++) {
            sb.append(prizeLevels[i].getDescription()).append(findWinLotto(scores, prizeLevels[i].getWin())).append(COUNTER);
        }
        sb.append(DIVIDER).append(TOTAL_REVENUE).append(percentage).append(END);
        return sb.toString();
    }

    private static int findWinLotto(List<Integer> scores, int win) {
        return (int) scores.stream().filter(score -> score == win).count();
    }

    private static double calculatePercentage(long revenue,  double payed) {
        return revenue / (payed / RATE);

    }

}
