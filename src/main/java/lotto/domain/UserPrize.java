package lotto.domain;

import static lotto.constant.GeneralConstant.ZERO;
import static lotto.constant.GeneralConstant.PRIZE_RANK_MAX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.RateOfReturnUtil;

public class UserPrize {
    private final List<Integer> prizeCounts;
    private int cost;
    private double rateOfReturn;

    public UserPrize() {
        prizeCounts = new ArrayList<>(Collections.nCopies(PRIZE_RANK_MAX, ZERO));
    }

    public void plusPrizeCount(int prizeRank) {
        int count = prizeCounts.get(prizeRank);
        prizeCounts.set(prizeRank, count + 1);
    }

    private void calcRateOfReturn() {
        rateOfReturn = RateOfReturnUtil.calcRateOfReturn(cost, prizeCounts);
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getRateOfReturn() {
        calcRateOfReturn();
        return rateOfReturn;
    }

    public List<Integer> getPrizeCounts() {
        return prizeCounts;
    }
}
