package lotto.domain.lottoresult;

import static lotto.utils.LottoConstants.LOTTO_PRICE;

public class EarningRate {
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
