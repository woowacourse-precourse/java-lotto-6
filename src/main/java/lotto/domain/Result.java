package lotto.domain;

import lotto.config.ConstNum;
import lotto.config.LottoRank;

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
        profit += (long) ConstNum.FIRST_PRIZE.getNum() * getCount(LottoRank.FIRST.getNum());
        profit += (long)ConstNum.SECOND_PRIZE.getNum() * getCount(LottoRank.SECOND.getNum());
        profit += (long)ConstNum.THIRD_PRIZE.getNum() * getCount(LottoRank.THIRD.getNum());
        profit += (long)ConstNum.FOURTH_PRIZE.getNum() * getCount(LottoRank.FOURTH.getNum());
        profit += (long)ConstNum.FIFTH_PRIZE.getNum() * getCount(LottoRank.FIFTH.getNum());

        return profit;
    }
}
