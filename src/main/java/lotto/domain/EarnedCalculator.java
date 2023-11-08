package lotto.domain;

import java.util.EnumMap;

public class EarnedCalculator {
    public double getEarningRate(EnumMap<LottoRank, Integer> lottoMap, int purchaseAmount) {
        int earnings = calculateTotalEarnings(lottoMap);
        return calculateEarningRate(earnings, purchaseAmount);
    }


    private int calculateTotalEarnings(EnumMap<LottoRank, Integer> lottoMap) {
        return lottoMap.entrySet().stream()
                .map(rank -> rank.getKey().getEarnings() * rank.getValue())
                .mapToInt(Integer::intValue)
                .sum();
    }

    private double calculateEarningRate(int earnings, int purchaseAmount) {
        double purchase = purchaseAmount * 1000;

        try {
            return earnings / purchase * 100;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

}
