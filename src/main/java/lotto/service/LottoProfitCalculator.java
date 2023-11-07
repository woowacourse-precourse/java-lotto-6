package lotto.service;

import lotto.constants.LottoPrize;

import static lotto.constants.LottoSetting.PRICE_PER_TICKET;

public class LottoProfitCalculator {

    private static final int TICKET_PRICE = PRICE_PER_TICKET.value();

    public double calculateProfitRate(int[] matchCounts, int ticketsPurchased) {
        long totalPrize = calculateTotalPrize(matchCounts);
        return (double) totalPrize / (ticketsPurchased * TICKET_PRICE) * 100.0;
    }

    private long calculateTotalPrize(int[] matchCounts) {
        long totalPrize = 0;
        LottoPrize[] prizes = LottoPrize.values();
        for (int i = 0; i < matchCounts.length; i++) {
            totalPrize += matchCounts[i] * prizes[i].getPrizeMoney();
        }
        return totalPrize;
    }
}

