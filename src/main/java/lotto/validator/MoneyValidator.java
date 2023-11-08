package lotto.validator;

import lotto.constant.ErrorConstants;
import lotto.constant.LottoConstants;
import lotto.util.Utils;

public class MoneyValidator {
    public static boolean isNumber(String money) {
        try {
            Utils.convertStringToLong(money);
        } catch (NumberFormatException e) {
            System.out.println(ErrorConstants.ERROR + ErrorConstants.INVALID_INPUT);
            return true;
        }
        return false;
    }

    public static boolean isValid(String stringMoney) {
        Long money = Utils.convertStringToLong(stringMoney);

        if (money % LottoConstants.LOTTO_PRICE != 0 || money == 0) {
            System.out.println(ErrorConstants.ERROR + ErrorConstants.INVALID_MONEY);
            return true;
        }
        return false;
    }
}
