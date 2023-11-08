package lotto.view.statistics;

import java.text.DecimalFormat;
import lotto.money.Money;
import lotto.statistics.Statistics;

public class LottoProfitOutputView {
    private static final String PROFIT_RESULT_FORMAT = "총 수익률은 %s%%입니다.\n";
    private static final DecimalFormat PROFIT_FORMAT = new DecimalFormat("#,###.0");

    public static void showProfit(Statistics statistics, Money money) {
        Double profit = statistics.calculateProfit(money);
        System.out.printf(PROFIT_RESULT_FORMAT, PROFIT_FORMAT.format(profit));
    }
}
