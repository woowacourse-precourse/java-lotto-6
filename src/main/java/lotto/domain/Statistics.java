package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum Statistics {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000),
    NON(0,0);

    private static final int STANDARD_BONUS_COUNT = 4;
    private static final String DECIMAL_FORMAT = "###,###";
    private final int count;
    private final int amount;

    Statistics(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String amountToString() {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
        String formatAmount = decimalFormat.format(amount);
        return formatAmount;
    }

    public static Statistics getStatistics(int matchCount,int bonusNumber, List<Integer> lottoNumbers) {
        if (isBonusNumber(matchCount, bonusNumber, lottoNumbers)) {
            return FIVE_BONUS;
        }
        return Arrays.stream(Statistics.values())
                .filter(data -> data.count == matchCount).findAny().orElse(NON);
    }

    private static boolean isBonusNumber(int matchCount, int bonusNumber, List<Integer> winningLotto) {
        return matchCount == STANDARD_BONUS_COUNT && winningLotto.contains(bonusNumber);
    }

    public static String statisticsResult(Map<Statistics, Integer> winningCount) {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(Statistics.values())
                .forEach(statistics -> makeOutputStatistics(statistics, sb, winningCount));

        return sb.toString();
    }

    public static void makeOutputStatistics(Statistics statistics, StringBuilder sb, Map<Statistics, Integer> winningCount) {
        Integer collectCount = winningCount.get(statistics);
        if (statistics.equals(FIVE_BONUS)) {
            sb.append(String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", statistics.count, statistics.amountToString(), collectCount));
            return;
        }
        sb.append(String.format("%d개 일치 (%s원) - %d개\n", statistics.count, statistics.amountToString(), collectCount));
    }


}
