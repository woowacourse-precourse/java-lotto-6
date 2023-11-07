package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rate {
    private final double rate;

    public Rate(long purchaseMoney, long reward) {
        double rewardRate = (double) reward / purchaseMoney * 100;
        BigDecimal bigDecimal = new BigDecimal(rewardRate);
        this.rate = bigDecimal.setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        return "총 수익률은 " + rate + "%입니다.\n";
    }
}
