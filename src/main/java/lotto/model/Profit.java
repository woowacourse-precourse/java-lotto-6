package lotto.model;

public class Profit {
    private final double profitRate;
    public Profit(int ticketPrice) {
        this.profitRate =  Double.parseDouble(String.format("%.1f",calculateTotalProfit(ticketPrice)));
    }

    public double calculateTotalProfit(int ticketPrice) {
        double profitSum = 0;
        for(Prize prize : Prize.values()) {
            profitSum  += prize.getPrice() * prize.getCount();
        }
        return calculateProfitRate(ticketPrice*1000,profitSum);
    }

    private double calculateProfitRate(int ticketPrice, double profitSum) {
        return profitSum / ticketPrice * 100.0;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
