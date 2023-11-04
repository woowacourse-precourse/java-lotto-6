package lotto.domain.player;

import lotto.domain.common.Money;

import java.util.Objects;

class PlayerMoney {

    private static final String UNKNOWN_MONEY_MESSAGE = "알 수 없는 금액입니다.";

    private final Money money;

    public PlayerMoney(Money money) {
        this.money = money;
    }

    public static PlayerMoney from(Money money) {
        checkMoneyNonNull(money);

        return new PlayerMoney(money);
    }

    private static void checkMoneyNonNull(Money money) {
        if (Objects.isNull(money)) {
            throw new IllegalArgumentException(UNKNOWN_MONEY_MESSAGE);
        }
    }

    public double calculateEarningRate(Money totalReturn) {
        checkMoneyNonNull(totalReturn);

        return totalReturn.divide(money) * 100;
    }
}
