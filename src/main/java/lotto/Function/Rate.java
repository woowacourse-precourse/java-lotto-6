package lotto.Function;

import lotto.Domain.Money;
import lotto.Domain.Prize;

public class Rate {

    private final double rate;
    //수익률=( 당첨 총 금액/투자 금액 )*100 %
    public Rate(Money money, PrizeLottoCompare prizeLottoCompare) {
        this.rate = (double) (getAllMoney(prizeLottoCompare) * 100) /money.getMoney();
    }

    private long getAllMoney(PrizeLottoCompare prizeLottoCompare) {
        int allMoney = 0;

        for (Prize prize : Prize.values()) {
            allMoney += prizeLottoCompare.getPrizeCount(prize) * prize.getMoney();
        }

        return allMoney;
    }

    public double getRate() {
        return rate;
    }
}
