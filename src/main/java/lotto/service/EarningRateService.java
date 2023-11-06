package lotto.service;

import lotto.model.LottoPrize;

import java.util.EnumMap;

public class EarningRateService {

    public double calculateEarningsRate(EnumMap<LottoPrize, Integer> winCount, int numberOfTicketsPurchased) {
        int earn = calculateEarnings(winCount);
        int purchaseAmount = numberOfTicketsPurchased * 1000;
        return calculateProfitRate(earn, purchaseAmount);
    }

    private int calculateEarnings(EnumMap<LottoPrize, Integer> winCount) {
        return winCount.entrySet().stream()
                .mapToInt(e -> e.getValue() * (int) e.getKey().getPrize())
                .sum();
    }

    private double calculateProfitRate(int earn, int purchaseAmount) {
        return (double) earn / purchaseAmount * 100;
    }
}