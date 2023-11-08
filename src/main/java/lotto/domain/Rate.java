package lotto.domain;

public class Rate {

    private final double rate;

    public Rate(Money money, PrizeResult prizeResult) {
        this.rate = (getAllMoney(prizeResult) * 0.1) / money.getLottosNumber();
    }

    private long getAllMoney(PrizeResult prizeResult) {
        int result = 0;

        for (PrizeMoney prizeMoney : PrizeMoney.values()) {
            result += prizeResult.getPrizeCount(prizeMoney) * prizeMoney.getMoney();
        }

        return result;
    }

    public double getRate() {
        return rate;
    }
}
