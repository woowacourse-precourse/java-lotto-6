package lotto.utils;

import static lotto.constants.LottoConstants.LOTTO_DIVISION;
import static lotto.constants.LottoConstants.LOTTO_NOT_DIVISION;

import lotto.exception.ErrorMsg;
import lotto.exception.UserInputException;

public class LottoUtils {

    public static int divisionLottoPrice(int price) {
        if (price % LOTTO_DIVISION != LOTTO_NOT_DIVISION) {
            throw new UserInputException(ErrorMsg.ERROR_LOTTO_PRICE_DIVISON.getMsg());
        }
        return (price / LOTTO_DIVISION);
    }
}
