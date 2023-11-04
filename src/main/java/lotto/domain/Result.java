package lotto.domain;

import java.util.ArrayList;

public class Result {
    private final ArrayList<Integer> result;

    public Result(ArrayList<Integer> result) {
        this.result = result;
    }

    public Integer getCount(Integer rank) {
        return result.get(rank);
    }

    public Double getProfitPercentage(Integer money) {
        Double percentage = (getProfit() / (double) money)*100;

        return Math.round(percentage * 100) / 100.0;
    }

    private Long getProfit() {
        Long profit = 0L;
        profit += (long)ConstNum.FIRST_PRIZE.getNum() * getCount(1);
        profit += (long)ConstNum.SECOND_PRIZE.getNum() * getCount(2);
        profit += (long)ConstNum.THIRD_PRIZE.getNum() * getCount(3);
        profit += (long)ConstNum.FOURTH_PRIZE.getNum() * getCount(4);
        profit += (long)ConstNum.FIFTH_PRIZE.getNum() * getCount(5);

        return profit;
    }
}
