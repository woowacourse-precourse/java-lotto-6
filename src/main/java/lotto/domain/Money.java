package lotto.domain;

import static lotto.constants.ExceptionMessage.MONEY_NOT_DIVIDED;
import static lotto.constants.ExceptionMessage.MONEY_OUT_RANGE;

import lotto.constants.LottoConstants;

public class Money {

    private final int money;

    private Money(final int money) {
        this.money = money;
    }

    public static Money from(final int money) {
        validate(money);
        return new Money(money);
    }

    private static void validate(final int money) {
        if (isDividedByPrice(money)) {
            throw new IllegalArgumentException(
                    String.format(MONEY_NOT_DIVIDED, LottoConstants.PRICE.getConstants()));
        }
        if (isInMinMoney(money)) {
            throw new IllegalArgumentException(
                    String.format(MONEY_OUT_RANGE, LottoConstants.PRICE.getConstants()));
        }
    }

    public int getMoney() {
        return money;
    }

    private static boolean isDividedByPrice(final int money) {
        return money % LottoConstants.PRICE.getConstants() != 0;
    }

    private static boolean isInMinMoney(final int money) {
        return money < LottoConstants.PRICE.getConstants();
    }

    public int requestLottoCount() {
        return (int) (money / LottoConstants.PRICE.getConstants());
    }

}
