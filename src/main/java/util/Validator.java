package util;

import errorhandler.CustomIllegalArgumentException;
import errorhandler.InputException;

public class Validator {
    public static void checkLottoAmmount(int money) {
        if (money % 1000 != 0) {
            throw new CustomIllegalArgumentException(InputException.WRONG_MONEY);
        }
    }
}
