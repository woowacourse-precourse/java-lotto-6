package lotto.valid;

import static lotto.consts.ErrorMsgConst.ERROR_MONEY_DIVIDE;
import static lotto.consts.ErrorMsgConst.ERROR_MONEY_MIN_VALUE;
import static lotto.consts.ErrorMsgConst.ERROR_MONEY_ONLY_NUMBER;
import static lotto.consts.LottoConst.LOTTO_PRICE;

public class MoneyValid {

    public static int validMoney(String input) {
        int money = validOnlyNumber(input);
        validDividing(money);
        validMinMoney(money);
        return money;
    }

    private static int validOnlyNumber(String input) {
        String reg = "^[0-9]*$";
        if (!input.matches(reg)) {
            throw new IllegalArgumentException(ERROR_MONEY_ONLY_NUMBER);
        }
        return Integer.parseInt(input);
    }

    private static void validDividing(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MONEY_DIVIDE);
        }
    }

    private static void validMinMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_MONEY_MIN_VALUE);
        }
    }
}
