package lotto.model;

import lotto.constant.ModelConstant;
import lotto.utils.FormatUtils;

public class Profit {

    private final String profitRate;

    public Profit(int ticketCount) {
        double rate = calculateTotalProfit(ticketCount);

        this.profitRate = FormatUtils.parseFormattedDoubleValue(rate);
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

    public String getProfitRate() {
        return profitRate;
    }

}
