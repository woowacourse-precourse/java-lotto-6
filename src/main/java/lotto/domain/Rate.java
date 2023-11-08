package lotto.domain;

import static lotto.configuration.Constants.Config.*;

public class Rate {
    private final double rate;

    public Rate(int purchaseMoney, int reward) {
        this.rate = (double) reward / purchaseMoney * PERCENT;
    }

    public double getRate() {
        return rate;
    }
}
