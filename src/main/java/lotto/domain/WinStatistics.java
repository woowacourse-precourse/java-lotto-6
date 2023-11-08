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


    public enum PrizeLevel {
        THREE_MATCH("3개 일치 (5,000원) - ", 3),
        FOUR_MATCH("4개 일치 (50,000원) - ", 4),
        FIVE_MATCH("5개 일치 (1,500,000원) - ", 5),
        FIVE_MATCH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 7),
        SIX_MATCH("6개 일치 (2,000,000,000원) - ", 6);

        private final String description;
        private final int win;

        PrizeLevel(String description, int win) {
            this.description = description;
            this.win = win;
        }

    }

    public static String getStatisticsString(List<Integer> scores, long revenue) {
        PrizeLevel[] prizeLevels = PrizeLevel.values();
        double payed = scores.size() * UNIT;
        BigDecimal winAmount = BigDecimal.valueOf(calculatePercentage(revenue, payed));
        return toString(scores, prizeLevels, winAmount);
    }

    private static String toString(List<Integer> scores, PrizeLevel[] prizeLevels, BigDecimal percentage) {
        StringBuilder sb = new StringBuilder();
        sb.append(STATISTICS).append(DIVIDER);
        for (int i = 0; i < prizeLevels.length; i++) {
            sb.append(prizeLevels[i].description).append(findWinLotto(scores, prizeLevels[i].win)).append(COUNTER);
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
