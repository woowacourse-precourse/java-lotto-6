package lotto.domain;

import lotto.constants.LottoConstants;

public class Money {

    private static int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(int money) {
        validate(money);
        return new Money(money);
    }

    private static void validate(int money) {
        if (isDividedByPrice(money)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 로또 구입 금액은 %d원 단위입니다.", LottoConstants.PRICE.getConstants()));
        }
        if (isInMinMoney(money)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 로또 최소 구입 금액은 %d원 입니다.", LottoConstants.PRICE.getConstants()));
        }
    }

    public int getMoney() {
        return money;
    }

    private static boolean isDividedByPrice(int money) {
        return money % LottoConstants.PRICE.getConstants() != 0;
    }

    private static boolean isInMinMoney(int money) {
        return money < LottoConstants.PRICE.getConstants();
    }

    public int requestLottoCount() {
        return (int) (money / LottoConstants.PRICE.getConstants());
    }

}
