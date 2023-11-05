package lotto.domain.player;

import lotto.domain.common.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

class PlayerMoney {

    private static final int PERCENTAGE_MULTIPLIER = 100;
    private static final int ROUND_SCALE = 3;
    private static final String UNKNOWN_MONEY_MESSAGE = "알 수 없는 금액입니다.";

    private final Money money;

    private PlayerMoney(Money money) {
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

        return calculateEarningRate(BigDecimal.valueOf(money.getValue()), BigDecimal.valueOf(totalReturn.getValue()));
    }

    private double calculateEarningRate(BigDecimal initialValue, BigDecimal totalValue) {
        return totalValue.divide(initialValue, ROUND_SCALE, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(PERCENTAGE_MULTIPLIER))
                .doubleValue();
    }
}
