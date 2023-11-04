package lotto.domain;

import lotto.constant.NumberConstants;

import java.util.*;

import static lotto.constant.NumberConstants.*;

public class ProfitCalculator {

    private final Map<LottoRank, Integer> lottoResult = new EnumMap<>(LottoRank.class);

    public ProfitCalculator() {
    }

    public void calculate(List<Integer> prize) {
        List<Integer> price = new ArrayList<>(Arrays.asList(FIFTH_PRIZE_MONEY.getValue(),
                SECOND_PRIZE_MONEY.getValue(),
                THIRD_PRIZE_MONEY.getValue(),
                FORTH_PRIZE_MONEY.getValue(),
                FIRST_PRIZE_MONEY.getValue()));

        for (int i = prize.size() - 1; i >= 0; i--) {
            totalSum += price.get(i) * prize.get(i);
        }
    }

    public int getTotalSum() {
        return totalSum;
    }

    public double earnRate(int totalSum, int lottoPurchaseAmount) {
        double earnRate = (double) totalSum / lottoPurchaseAmount * 100;
        return Math.round(earnRate * 100.0) / 100.0;
    }
}
