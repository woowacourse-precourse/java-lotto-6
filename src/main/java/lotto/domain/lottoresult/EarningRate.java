package lotto.domain.lottoresult;

public class EarningRate {
    private static final int LOTTO_PRICE = 1_000;

    private final double rate;

    public EarningRate(double numOfTickets, double earnedMoney) {
        this.rate = calcRate(numOfTickets, earnedMoney);
    }

    public double getRate() {
        return rate;
    }

    private double calcRate(double numOfTickets, double earnedMoney) {
        return earnedMoney / (numOfTickets * LOTTO_PRICE) * 100;
    }
}
