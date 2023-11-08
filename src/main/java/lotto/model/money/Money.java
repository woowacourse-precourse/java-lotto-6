package lotto.model.money;

import java.util.Map;
import lotto.utils.constant.LottoWinningConstant;

public class Money {
    public static final int DEFAULT_MONEY = 0;

    private int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money of(int money) {
        return new Money(money);
    }

    public int getMoney() {
        return money;
    }

    public void calculateTotalPrize(Map<LottoWinningConstant, Integer> result) {
        int totalPrize = 0;
        for (LottoWinningConstant lottoWinningConstant : LottoWinningConstant.values()) {
            totalPrize += lottoWinningConstant.getWinningMoney() * result.get(lottoWinningConstant);
        }
        money = totalPrize;
    }
}
