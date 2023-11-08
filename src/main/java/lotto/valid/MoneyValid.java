package lotto.valid;

import static lotto.consts.ErrorMsgConst.ERROR_MONEY_DIVIDE;
import static lotto.consts.ErrorMsgConst.ERROR_MONEY_MIN_VALUE;
import static lotto.consts.LottoConst.LOTTO_PRICE;
import static lotto.valid.CommonValid.validNotBlank;
import static lotto.valid.CommonValid.validOnlyNumber;

public class MoneyValid {

    public static int validMoney(String input) {
        validNotBlank(input);
        int money = validOnlyNumber(input);
        validMinMoney(money);
        validDividing(money);
        return money;
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
