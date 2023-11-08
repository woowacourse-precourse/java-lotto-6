package lotto.model;

import lotto.constant.ModelConstant;

public class Profit {
    private final double profitRate;
    public Profit(int ticketCount) {
        this.profitRate =  Double.parseDouble(String.format("%.1f",calculateTotalProfit(ticketCount)));
    }

    public double calculateTotalProfit(int ticketCount) {
        double profitSum = 0;
        for(Prize prize : Prize.values()) {
            profitSum  += prize.getPrice() * prize.getCount();
        }
        return calculateProfitRate(ticketCount * ModelConstant.TICKET_PRICE, profitSum);
    }

    private double calculateProfitRate(int ticketPrice, double profitSum) {
        return profitSum / ticketPrice * ModelConstant.RATE_PERCENTAGE;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
