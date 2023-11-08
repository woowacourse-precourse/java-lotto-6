package lotto.model;

import static lotto.ErrorMessage.INDIVISIBLE_NUMBER;
import static lotto.ErrorMessage.NOT_NUMBER_FORMAT;
import static lotto.ErrorMessage.ZERO_NUMBER;
import static lotto.configuration.LottoConfiguration.LOTTO_PRICE;

import lotto.view.OutPutView;

public class Money {
    private int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money createMoney(String money) {
        if (isValidMoneyFormat(money)) {
            return new Money(Integer.parseInt(money));
        }
        return null;

    }

    public int moneyToLottoCount() {
        return money / LOTTO_PRICE.get();
    }

    private static boolean isValidMoneyFormat(String money) {
        return isNumber(money)
                && isDivisibleMoney(Integer.parseInt(money))
                && isZeroMoney(Integer.parseInt(money));
    }

    private static boolean isDivisibleMoney(int money) {
        if (money % LOTTO_PRICE.get() != 0) {
            OutPutView.println(INDIVISIBLE_NUMBER.getMessage());
            return false;
        }
        return true;
    }

    private static boolean isZeroMoney(int money) {
        if (money == 0) {
            OutPutView.println(ZERO_NUMBER.getMessage());
            return false;
        }
        return true;
    }

    private static boolean isNumber(String money) {
        if (!money.matches("\\d+")) {
            OutPutView.println(NOT_NUMBER_FORMAT.getMessage());
            return false;
        }
        return true;
    }
}
