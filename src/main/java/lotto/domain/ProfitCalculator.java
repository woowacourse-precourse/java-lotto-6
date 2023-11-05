package lotto.domain;

import lotto.constant.NumberConstants;

import java.util.*;

import static lotto.constant.NumberConstants.*;

public class ProfitCalculator {
    public int calculateProfit(LottoResult lottoResult) {
        return lottoResult.getLOTTO_RESULT().entrySet().stream()
                .filter(rank -> rank.getKey() != LottoRank.NO_RANK)
                .map(rank -> rank.getKey().getPrizeMoney() * rank.getValue())
                .mapToInt(Integer::intValue)
                .sum();
    }

    public double calculateProfitMargin(int profit, int amount) {
        double result = (double) profit / amount;
        return Math.round(result * 100.0) / 100.0;
    }
}
