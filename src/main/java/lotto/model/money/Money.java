package lotto.model.money;

import static lotto.exception.ExceptionMessage.MONEY_OUR_RANGE;

import java.util.Map;
import lotto.utils.constant.LottoWinningConstant;

public class Money {
    public static final int DEFAULT_MONEY = 0;

    private int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money of(int money) {
        validateMoneyInRange(money);
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

    private static void validateMoneyInRange(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(MONEY_OUR_RANGE.getMessage());
        }
    }
}
