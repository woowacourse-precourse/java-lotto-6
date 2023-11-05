package lotto.service;

public class PrizeCalculator implements Calculator {
    @Override
    public Double calculate(Long revenue, Long investmentCost) {
        return (double) revenue / investmentCost;
    }
}
