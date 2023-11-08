package lotto.domain;

import java.util.EnumMap;

import static lotto.config.LottoConfig.lottoPrice;

public class EarningCalculator {
    public double getEarningRate(EnumMap<LottoRank, Integer> lottoMap, int purchaseAmount) {
        double earnings = calculateTotalEarnings(lottoMap);
        return calculateEarningRate(earnings, purchaseAmount);
    }


    public double calculateTotalEarnings(EnumMap<LottoRank, Integer> lottoMap) {
        return lottoMap.entrySet().stream()
                .map(rank -> rank.getKey().getEarnings() * rank.getValue())
                .mapToDouble(Integer::intValue)
                .sum();
    }

    private double calculateEarningRate(double earnings, int purchaseAmount) {
        double purchase = purchaseAmount * lottoPrice;

        try {
            return earnings / purchase * 100;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

}
