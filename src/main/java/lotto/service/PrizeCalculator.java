package lotto.service;

import lotto.model.Revenue;

public class PrizeCalculator implements Calculator<Revenue> {
    @Override
    public Revenue calculate(Long revenue, Long investmentCost) {
        return new Revenue((double) revenue / investmentCost);
    }
}
