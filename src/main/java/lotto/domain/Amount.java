package lotto.domain;

import lotto.constant.LottoNumber;

public class Amount {
    private static final int PERCENT = 100;
    private int purchase;
    private double winnings;

    public void setPurchase(int purchase) {
        this.purchase = purchase;
    }

    public void setWinnings(double winnings) {
        this.winnings = winnings;
    }

    public int getCount() {
        return purchase / LottoNumber.PRICE.getValue();
    }

    public double getEarnings() {
        return winnings / purchase * PERCENT;
    }
}
