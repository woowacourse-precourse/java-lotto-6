package lotto.validate;

import lotto.exception.ExceptionManager;

public class MoneyValidate {

    public static void validate(int money) {
        checkMoney(money);
    }

    private static void checkMoney(int money) {
        if (money < 0) {
            throw ExceptionManager.ERROR_MSG_PREFIX.createIllegalArgumentException(
                    "0원 이상 입력해야 합니다.");
        }
    }
}
