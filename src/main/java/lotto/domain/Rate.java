package lotto.domain;

public class Rate {

    private final double rate;

    public Rate(Money money, LottoResult lottoResult) {
        this.rate = (getAllMoney(lottoResult) * 0.1) / money.countMoney();
    }

    private long getAllMoney(LottoResult lottoResult) {
        int result = 0;

        for (Prize prize : Prize.values()) {
            result += lottoResult.getPrizeCount(prize) * prize.getMoney();
        }

        return result;
    }

    public double getRate() {
        return rate;
    }
}
