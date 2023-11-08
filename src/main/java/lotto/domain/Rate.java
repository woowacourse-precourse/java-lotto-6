package lotto.domain;

import lotto.configuration.Constants;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static lotto.configuration.Constants.Config.*;

public class Rate {
    private final double rate;

    public Rate(int purchaseMoney, int reward) {
        double rewardRate = (double) reward / purchaseMoney * PERCENT;
        BigDecimal bigDecimal = new BigDecimal(rewardRate);
        this.rate = bigDecimal.setScale(SCALE, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        return Constants.Message.RATE_IS + rate + Constants.Message.PERCENT;
    }
}
