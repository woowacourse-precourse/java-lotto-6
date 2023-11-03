package lotto.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Result {
    private final ArrayList<Integer> result;

    public Result(ArrayList<Integer> result) {
        this.result = result;
    }

    public Integer getCount(Integer rank) {
        return result.get(rank);
    }

    public String getProfitPercentage(Integer money) {
        Long profit=getProfit();

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String roundedNum = decimalFormat.format(profit / money);

        return roundedNum;
    }

    private Long getProfit() {
        Long profit = 0L;
        profit += 2_000_000_000 * getCount(1);
        profit += 30_000_000 * getCount(2);
        profit += 1_500_000 * getCount(3);
        profit += 50_000 * getCount(4);
        profit += 5_000 * getCount(5);

        return profit;
    }
}
