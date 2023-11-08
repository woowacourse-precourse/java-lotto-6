package lotto.model;

public class Rate {
    private final int totalWinningAmount;
    private final int ticketCount;
    private final int TICKET_PRICE = 1000;

    public Rate(int totalWinningAmount, int ticketCount) {
        this.totalWinningAmount = totalWinningAmount;
        this.ticketCount = ticketCount;
    }

    public double calculateEarningRate() {
        double earningRate = (double) totalWinningAmount / (ticketCount * TICKET_PRICE);
        earningRate = Math.round(earningRate * 100.0) / 100.0;
        return earningRate;
    }

}
