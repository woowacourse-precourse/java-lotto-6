package lotto.service;

import lotto.model.Revenue;

public class PrizeCalculator implements Calculator<Revenue> {
    @Override
    public Revenue calculate(Long income, Long investmentCost) {
        return new Revenue((double) income / investmentCost);
    }
}
